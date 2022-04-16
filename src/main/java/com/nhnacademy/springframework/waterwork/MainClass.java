package com.nhnacademy.springframework.waterwork;

import com.nhnacademy.springframework.waterwork.config.ConfigFile;
import com.nhnacademy.springframework.waterwork.service.CalculateFee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ConfigFile.class)){
context.getBean("calculateFee", CalculateFee.class).calculator(20);
        }
    }
}
