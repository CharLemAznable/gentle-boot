package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import com.github.charlemaznable.core.net.common.Mapping;
import com.github.charlemaznable.core.net.ohclient.OhClient;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.charlemaznable.core.net.ohclient.OhFactory.getClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplication.class,
        args = "--nodeId=test",
        webEnvironment = DEFINED_PORT)
public class ArgumentsInitializerTest {

    static {
        MockDiamondServer.setUpMockServer();
        MockDiamondServer.setConfigInfo("Test", "config.test", "" +
                "deploy.context-path=/test-arg\n" +
                "deploy.port=7515\n");
    }

    @AfterAll
    public static void afterAll() {
        MockDiamondServer.tearDownMockServer();
    }

    @Autowired
    private TestWebServerCustomizer customizer;
    private TestClient testClient = getClient(TestClient.class);

    @Test
    public void testArgumentsInitializer() {
        assertTrue(customizer.isCustomized());

        val arguments = new Arguments();
        assertFalse(arguments.getProperties().isEmpty());
        assertEquals("test", arguments.getStr("nodeId"));

        assertEquals("If you wish to be the king of the jungle,\n" +
                "it's not enough to act like a king.\n" +
                "You must be the king.", testClient.index());
    }

    @OhClient
    @Mapping("http://127.0.0.1:7515/test-arg")
    public interface TestClient {

        String index();
    }
}
