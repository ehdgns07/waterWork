package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.comparerator.ComparatorForAscending;
import java.util.Collections;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingResultService implements LogingService{
    Calculate calculate;
    ComparatorForAscending comp = new ComparatorForAscending();
    static final Log log = LogFactory.getLog(LoggingResultService.class);

    public LoggingResultService(Calculate calculate){
        this.calculate = calculate;
    }

    @Override

    public void printingResult() {
        Collections.sort(calculate.getCalculatedWaterFee(), comp);
        for (int i = 0; i < 5; i++) {
            log.info(calculate.getCalculatedWaterFee().get(i).toString());
        }
    }
}
