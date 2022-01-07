package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.config.Arguments;
import com.github.charlemaznable.gentle.spring.factory.SpringFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;

import static com.github.charlemaznable.core.lang.Condition.checkNotNull;

@SpringFactory(SpringApplicationRunListener.class)
public final class ArgumentsInitializer implements SpringApplicationRunListener {

    public ArgumentsInitializer(SpringApplication application, String[] args) {
        checkNotNull(application);
        Arguments.initial(args);
    }
}
