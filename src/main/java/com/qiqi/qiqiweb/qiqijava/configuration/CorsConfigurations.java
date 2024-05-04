package com.qiqi.qiqiweb.qiqijava.FileConf.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurations  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT")
                .allowedHeaders("X-Requested-With", "Content-Type", "Authorization")
                .allowCredentials(true);
    }
}