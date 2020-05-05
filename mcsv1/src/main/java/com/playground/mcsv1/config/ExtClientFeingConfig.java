package com.playground.mcsv1.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ExtClientFeingConfig {

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
