package com.example.SpringBoot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class BeanConfig {
    @Bean
    public TestB testB(){
        TestB testB = new TestB("Ilias",2424);
        testB.setCode("Mark");
        return testB;
    }



}
