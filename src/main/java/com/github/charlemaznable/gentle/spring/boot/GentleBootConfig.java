package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.miner.MinerConfig;

import java.util.Properties;

@MinerConfig(group = "${BootGroup}")
public interface GentleBootConfig {

    @MinerConfig("${BootId}")
    Properties properties();
}
