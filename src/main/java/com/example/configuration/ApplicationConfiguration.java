package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = DatabaseConfiguration.class)
public class ApplicationConfiguration {

}
