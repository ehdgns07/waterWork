package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CalculateFee implements Calculate {

    DataRead dataRead;
    List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();

    public CalculateFee(DataRead dataRead) {
        this.dataRead = dataRead;
    }

    @Override

    public void calculator(long amount) {

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
