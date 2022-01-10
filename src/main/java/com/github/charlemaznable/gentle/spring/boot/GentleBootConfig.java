package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.miner.DefaultEmptyValue;
import com.github.charlemaznable.core.miner.MinerConfig;

import java.util.Properties;

@MinerConfig(group = "${BootGroup}")
public interface GentleBootConfig {

    @DefaultEmptyValue
    @MinerConfig("${BootId}")
    Properties properties();
}
