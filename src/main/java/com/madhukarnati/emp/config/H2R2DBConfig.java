package com.madhukarnati.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

/**
 * Database configuration
 */
@Configuration
public class H2R2DBConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:h2:mem:///testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
    }
}
