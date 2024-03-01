package com.SharpDevs.Recipe.Mania.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ControllerAdvice
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:3000")
            .allowedHeaders("GET","POST","PUT","DELETE","PATCH")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    }
}