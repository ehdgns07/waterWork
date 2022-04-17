package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.comparerator.ComparatorForAscending;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class LogingResultService implements LogingService{
    Calculate calculate;
    ComparatorForAscending comp = new ComparatorForAscending();


    public LogingResultService(Calculate calculate){
        this.calculate = calculate;
    }

    @Override

    public void printingResult() {
        Collections.sort(calculate.getCalculatedWaterFee(), comp);
        for (int i = 0; i < 5; i++) {
            System.out.println(calculate.getCalculatedWaterFee().get(i).toString());
        }
    }
}
