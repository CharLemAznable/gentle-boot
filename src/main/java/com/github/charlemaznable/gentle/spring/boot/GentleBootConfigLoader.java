package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.Properties;
import java.util.ServiceLoader;

import static com.github.charlemaznable.core.lang.Condition.nullThen;
import static com.github.charlemaznable.core.miner.MinerFactory.getMiner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GentleBootConfigLoader {

    private static final String BOOT_GROUP = "BootGroup";
    private static final String BOOT_ID = "BootId";

    private static GentleBootConfig loadConfig;

    static {
        loadGentleBootConfig();
    }

    public static Properties getConfigProperties() {
        return nullThen(loadConfig, GentleBootConfigLoader::defaultConfig).properties();
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

    private static GentleBootConfig defaultConfig() {
        val arguments = new Arguments();
        if (arguments.exists(BOOT_GROUP) && arguments.exists(BOOT_ID)) {
            return getMiner(GentleBootConfig.class);
        }
        return Properties::new;
    }
}
