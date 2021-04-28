package com.github.charlemaznable.gentle;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

import static com.github.charlemaznable.core.lang.Condition.nullThen;
import static com.github.charlemaznable.core.miner.MinerFactory.getMiner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpringFacetCodeInspection")
@Component
public class TestWebServerCustomizer
        implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    private final TestWebServerCustomizerConfig config;
    @Getter
    private boolean customized;

    @Autowired
    public TestWebServerCustomizer(@Nullable TestWebServerCustomizerConfig config) {
        this.config = nullThen(config, () -> getMiner(TestWebServerCustomizerConfig.class));
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        assertEquals("/test-arg", config.contextPath());
        assertEquals(7515, config.port());

        factory.setContextPath(config.contextPath());
        factory.setPort(config.port());

        this.customized = true;
    }
}
