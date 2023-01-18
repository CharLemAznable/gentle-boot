package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.httpclient.common.Mapping;
import com.github.charlemaznable.httpclient.ohclient.OhClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.charlemaznable.httpclient.ohclient.OhFactory.getClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(classes = TestApplication.class,
        webEnvironment = DEFINED_PORT)
public class GentleBootInitializerNoArgTest {

    private final TestClient testClient = getClient(TestClient.class);

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
        assertEquals("""
                If you wish to be the king of the jungle,
                it's not enough to act like a king.
                You must be the king.""", testClient.index());
    }

    @OhClient
    @Mapping("http://127.0.0.1:7514/test")
    public interface TestClient {

        String index();
    }
}
