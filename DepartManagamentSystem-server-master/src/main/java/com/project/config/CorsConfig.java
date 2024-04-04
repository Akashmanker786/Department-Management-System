package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
       // config.setAllowCredentials("*");
        config.addAllowedOrigin("*"); // You can set specific origins if needed
        config.addAllowedHeader("*"); // You can set specific headers if needed
        config.addAllowedMethod("*"); // You can set specific HTTP methods if needed
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
