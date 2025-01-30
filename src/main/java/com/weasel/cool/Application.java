package com.weasel.cool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// not 100% sure if we need the component scan; stuff stopped working without it in the early days,
// but i can't remember why, or whether we have the same situation here
@ComponentScan(basePackages = "com.weasel.cool")
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
