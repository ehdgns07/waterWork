package com.nhnacademy.springframework.waterwork.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileParser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateFeeTest {
    @DisplayName("입력받은 값을 이용해 해당하는 구간의 unitPrice와 곱해서 최종 결과값이 제대로 나오고, 저장되는지 테스트")
    @Test
    void calculator() {
        List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();
        FileParser fileParser;

        fileParser = new CsvFileParser();
        fileParser.read("./Tariff_20220331.csv");

        int amount = 1000;
        AtomicLong remainAmount = new AtomicLong(amount);

        fileParser.findAll().stream().forEach((waterFee -> {
            if (remainAmount.get() >= waterFee.getSectionStart() &&
                remainAmount.get() <= waterFee.getSectionEnd()) {
                calculatedWaterFee.add(new CalculatedWaterFee(waterFee.getNameOfCity(),
                    waterFee.getSector(), waterFee.getUnitPrice(),
                    waterFee.getUnitPrice() * amount));
            }
        }));

        assertThat(calculatedWaterFee.size()).isEqualTo(103);
        assertThat(calculatedWaterFee.get(0).getNameOfCity()).isEqualTo(" 동두천시 ");
        assertThat(calculatedWaterFee.get(0).getFee()).isEqualTo(1530000);
        assertThat(calculatedWaterFee.get(102).getNameOfCity()).isEqualTo(" 고성군 ");
        assertThat(calculatedWaterFee.get(102).getFee()).isEqualTo(2170000);

    }
}
