package com.babu.schoolmanagement.School_management.config;

import com.babu.schoolmanagement.School_management.utils.PhoneNumberValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PhoneNumberValidator phoneNumberValidator(){
        return new PhoneNumberValidator();
    }
}
