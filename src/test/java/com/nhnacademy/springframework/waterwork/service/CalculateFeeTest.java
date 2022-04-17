package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.comparerator.ComparatorForAscending;
import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CalculateFeeTest {

    @Test
    void calculator() {
        List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();
        FileRepository fileRepository;

        fileRepository = new CsvFileParser();
        fileRepository.read("./Tariff_20220331.csv");
        AtomicLong finalFee = new AtomicLong(0);
        int amount = 1000;
        AtomicLong remainAmount = new AtomicLong(amount);
        String sector = null;
        ComparatorForAscending comp = new ComparatorForAscending();


        fileRepository.findAll().stream().forEach((waterFee -> {
            if (remainAmount.get() >= waterFee.getSectionStart() &&
                remainAmount.get() <= waterFee.getSectionEnd()) {
                calculatedWaterFee.add(new CalculatedWaterFee(waterFee.getNameOfCity(),
                    waterFee.getSector(), waterFee.getUnitPrice(),
                    waterFee.getUnitPrice() * amount));
            }
        }));
        Collections.sort(calculatedWaterFee, comp);
        for (int i = 0; i < 5; i++) {
            System.out.println(calculatedWaterFee.get(i).toString());
        }

    }
}
