package com.morningbuddies.morningbuddies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorAwareConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Return the current authenticated user or system if not authenticated
        return () -> Optional.ofNullable(getCurrentUser());
    }

    private String getCurrentUser() {
        // Implement logic to fetch the current user
        // Example: return SecurityContextHolder.getContext().getAuthentication().getName();
        return "system"; // For demonstration, use "system" as default user
    }
}