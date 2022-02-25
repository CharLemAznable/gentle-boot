package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.core.spring.FullBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(nameGenerator = FullBeanNameGenerator.class)
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
