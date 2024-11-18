package com.example.my_book_manager_system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 这是 Spring 配置类的标记
public class WebConfig implements WebMvcConfigurer {

    // 配置 CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许所有路径（/**）的跨域请求
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")  // 允许来自 localhost:8080 的跨域请求
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                .allowedHeaders("*")  // 允许所有的请求头
                .allowCredentials(true);  // 是否允许发送 cookie（如有）
    }
}
