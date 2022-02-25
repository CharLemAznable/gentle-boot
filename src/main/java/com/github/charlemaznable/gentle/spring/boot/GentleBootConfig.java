package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.miner.DefaultEmptyValue;
import com.github.charlemaznable.miner.MinerConfig;

import java.util.Properties;

@MinerConfig(group = "${BootGroup}")
public interface GentleBootConfig {

    @DefaultEmptyValue
    @MinerConfig("${BootId}")
    Properties properties();
}
