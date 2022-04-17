package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.comparerator.ComparatorForAscending;
import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CalculateFee implements Calculate {

    DataRead dataRead;
    List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();

    public CalculateFee(DataRead dataRead) {
        this.dataRead = dataRead;
    }

    @Override

    public void calculator(int amount) {

        AtomicLong atomicAmount = new AtomicLong(amount);
        calculatedWaterFee.clear();

        dataRead.findAll().stream().forEach((waterFee -> {
            if (atomicAmount.get() >= waterFee.getSectionStart() &&
                atomicAmount.get() <= waterFee.getSectionEnd()) {
                calculatedWaterFee.add(new CalculatedWaterFee(waterFee.getNameOfCity(),
                    waterFee.getSector(), waterFee.getUnitPrice(),
                    waterFee.getUnitPrice() * amount));
            }
        }));


    }

    public List<CalculatedWaterFee> getCalculatedWaterFee() {
        return calculatedWaterFee;
    }
}
