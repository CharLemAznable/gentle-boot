package com.github.charlemaznable.gentle;

import com.github.charlemaznable.core.config.Arguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;

import static com.github.charlemaznable.core.lang.Condition.checkNotNull;

public class ArgumentsInitializer implements SpringApplicationRunListener {

    public ArgumentsInitializer(SpringApplication application, String[] args) {
        checkNotNull(application);
        Arguments.initial(args);
    }
}
