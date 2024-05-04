package com.example.qiqijava.qiqiweb.configuration;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;


@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(100, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(100, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}

