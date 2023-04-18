package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import com.github.charlemaznable.httpclient.annotation.Mapping;
import com.github.charlemaznable.httpclient.ohclient.OhClient;
import com.github.charlemaznable.httpclient.vxclient.VxClient;
import com.github.charlemaznable.httpclient.vxclient.elf.VertxReflectFactory;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.github.charlemaznable.core.context.FactoryContext.ReflectFactory.reflectFactory;
import static com.github.charlemaznable.httpclient.ohclient.OhFactory.ohLoader;
import static com.github.charlemaznable.httpclient.vxclient.VxFactory.vxLoader;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(classes = TestApplication.class,
        args = {"--BootGroup=Test", "--BootId=config.test"},
        webEnvironment = DEFINED_PORT)
public class GentleBootInitializerTest {

    @BeforeAll
    public static void beforeAll() {
        GentleBootConfigLoader.loadGentleBootConfig();
        MockDiamondServer.setUpMockServer();
        MockDiamondServer.setConfigInfo("Test", "config.test", """
                server.servlet.context-path=/test-arg
                server.port=7515
                """);
    }

    @AfterAll
    public static void afterAll() {
        MockDiamondServer.tearDownMockServer();
    }

    @Test
    public void testGentleBootInitializer() {
        val arguments = new Arguments();
        assertFalse(arguments.getProperties().isEmpty());
        assertEquals("Test", arguments.getStr("BootGroup"));
        assertEquals("config.test", arguments.getStr("BootId"));

        val testClient = ohLoader(reflectFactory()).getClient(TestClient.class);
        assertEquals("""
                If you wish to be the king of the jungle,
                it's not enough to act like a king.
                You must be the king.""", testClient.index());

        val testClient2 = vxLoader(new VertxReflectFactory(Vertx.vertx())).getClient(TestClient2.class);
        val finished = new AtomicBoolean();
        testClient2.index().onSuccess(resp -> {
            assertEquals("""
                If you wish to be the king of the jungle,
                it's not enough to act like a king.
                You must be the king.""", resp);
            finished.set(true);
        });
        await().forever().until(finished::get);
    }

    @OhClient
    @Mapping("http://127.0.0.1:7515/test-arg")
    public interface TestClient {

        String index();
    }

    @VxClient
    @Mapping("http://127.0.0.1:7515/test-arg")
    public interface TestClient2 {

        Future<String> index();
    }
}
