package com.smarts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigCorsFilter implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry corsRegistry) {
            corsRegistry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("http://10.50.2.203:8080")
                    .allowedHeaders("*")
                    .allowCredentials(false)
                    .maxAge(-1);
        }
}
