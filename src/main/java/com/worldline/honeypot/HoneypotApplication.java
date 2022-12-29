package com.worldline.honeypot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HoneypotApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HoneypotApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

}
