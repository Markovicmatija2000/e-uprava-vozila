package com.project.mup_vehicles.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoUserDetailsConfig {
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        // Return an empty manager so Boot doesn’t create the default in‑memory user
        return new org.springframework.security.provisioning.InMemoryUserDetailsManager();
    }
}
