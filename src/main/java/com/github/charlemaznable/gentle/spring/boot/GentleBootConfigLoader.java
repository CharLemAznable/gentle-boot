package com.github.charlemaznable.gentle.spring.boot;

import lombok.NoArgsConstructor;
import lombok.val;

import java.util.Properties;
import java.util.ServiceLoader;

import static com.github.charlemaznable.configservice.ConfigFactory.getConfig;
import static com.github.charlemaznable.core.lang.Condition.nullThen;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class GentleBootConfigLoader {

    private static GentleBootConfig loadConfig;

    static {
        loadGentleBootConfig();
    }

    public static Properties getConfigProperties() {
        return nullThen(loadConfig, () -> getConfig(GentleBootConfig.class)).properties();
    }

    static void loadGentleBootConfig() {
        loadConfig = findGentleBootConfig();
    }

    private static GentleBootConfig findGentleBootConfig() {
        val configs = ServiceLoader.load(GentleBootConfig.class).iterator();
        if (!configs.hasNext()) return null;

        val result = configs.next();
        if (configs.hasNext())
            throw new IllegalStateException("Multiple GentleBootConfig Defined");
        return result;
    }
}
