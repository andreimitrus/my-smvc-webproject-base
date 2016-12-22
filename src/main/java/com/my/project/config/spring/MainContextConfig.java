package com.my.project.config.spring;

import com.my.project.support.ApplicationConstants;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author amitrus
 */
@Configuration
@ComponentScan(basePackages = "com.my.project.**.service")
public class MainContextConfig {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new ClassPathResource("application.properties")
        });

        return propertyPlaceholderConfigurer;
    }

    @Bean(initMethod = "getInstance")
    public ApplicationConstants applicationConstants() {
        return ApplicationConstants.getInstance();
    }
}
