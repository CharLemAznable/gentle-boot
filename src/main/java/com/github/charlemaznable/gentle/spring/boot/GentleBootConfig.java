package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.configservice.annotation.DefaultEmptyValue;
import com.github.charlemaznable.configservice.apollo.ApolloConfig;
import com.github.charlemaznable.configservice.diamond.DiamondConfig;

import java.util.Properties;

@ApolloConfig(namespace = "${BootGroup}")
@DiamondConfig(group = "${BootGroup}")
public interface GentleBootConfig {

    @DefaultEmptyValue
    @ApolloConfig("${BootId}")
    @DiamondConfig("${BootId}")
    Properties properties();
}
