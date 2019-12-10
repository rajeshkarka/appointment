package com.intuit.demo.boot.appointment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@PropertySource("classpath:config.properties")
public class Cors extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String origins = environment.getProperty("origins");
       // registry.addMapping("/api/**").allowedOrigins(origins.split(","));
    }
}