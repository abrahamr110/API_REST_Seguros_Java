package com.es.segurosinseguros.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AppConfig {
    @Bean
    public Date currentDate() {
        return new Date();
    }
}

