package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.configservice.Config;
import com.github.charlemaznable.configservice.annotation.DefaultEmptyValue;

import java.util.Properties;

@Config(keyset = "${BootGroup}")
public interface GentleBootConfig {

    @DefaultEmptyValue
    @Config("${BootId}")
    Properties properties();
}
