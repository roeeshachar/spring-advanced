package com.roee.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.roee.spring.controllers", "com.roee.spring.bl", "com.roee.spring.dl.cassandra"})
public class WebConfig implements WebMvcConfigurer {
}


