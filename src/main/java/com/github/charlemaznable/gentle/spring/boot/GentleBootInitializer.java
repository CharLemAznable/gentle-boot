package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import com.github.charlemaznable.gentle.spring.factory.SpringFactory;
import lombok.val;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import static com.github.charlemaznable.core.lang.Condition.checkNotNull;
import static com.github.charlemaznable.core.miner.MinerFactory.getMiner;

@SpringFactory(SpringApplicationRunListener.class)
public final class GentleBootInitializer implements SpringApplicationRunListener {

    public static final String GENTLE_INIT_PROP_SRC = "GentleBootInitializerPropertySource";

    private static final String BOOT_GROUP = "BootGroup";
    private static final String BOOT_ID = "BootId";

    public GentleBootInitializer(SpringApplication application, String[] args) {
        checkNotNull(application);
        Arguments.initial(args);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
                                    ConfigurableEnvironment environment) {
        val arguments = new Arguments();
        if (arguments.exists(BOOT_GROUP) && arguments.exists(BOOT_ID)) {
            environment.getPropertySources().addFirst(new PropertiesPropertySource(
                    GENTLE_INIT_PROP_SRC, getMiner(GentleBootConfig.class).properties()));
        }
    }
}
