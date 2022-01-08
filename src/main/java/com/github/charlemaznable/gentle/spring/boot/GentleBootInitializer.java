package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import com.github.charlemaznable.gentle.spring.factory.SpringFactory;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import static com.github.charlemaznable.core.lang.Condition.checkNotNull;

@SpringFactory(SpringApplicationRunListener.class)
public final class GentleBootInitializer implements SpringApplicationRunListener {

    public static final String GENTLE_INIT_PROP_SRC = "GentleBootInitializerPropertySource";

    public GentleBootInitializer(SpringApplication application, String[] args) {
        checkNotNull(application);
        Arguments.initial(args);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
                                    ConfigurableEnvironment environment) {
        environment.getPropertySources().addFirst(new PropertiesPropertySource(
                GENTLE_INIT_PROP_SRC, GentleBootConfigLoader.getConfigProperties()));
    }
}
