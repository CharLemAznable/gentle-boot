package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.miner.MinerConfig;

@MinerConfig(group = "Test", dataId = "config.${nodeId}")
public interface TestWebServerCustomizerConfig {

    @MinerConfig(dataId = "deploy.context-path", defaultValue = "/test")
    String contextPath();

    @MinerConfig(dataId = "deploy.port", defaultValue = "7514")
    int port();
}
