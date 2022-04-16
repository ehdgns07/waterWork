package com.nhnacademy.springframework.waterwork.service;

import org.springframework.beans.factory.annotation.Autowired;

public class LoingResultService implements LogingService{
    Calculate calculate;

    @Autowired
    public LoingResultService(Calculate calculate){
        this.calculate = calculate;
    }
    @Override
    public void printingResult(int amount) {
        calculate.calculator(amount);
    }
}
