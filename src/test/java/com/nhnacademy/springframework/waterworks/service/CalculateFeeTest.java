package com.nhnacademy.springframework.waterworks.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springframework.waterworks.repository.CalculatedWaterFee;
import com.nhnacademy.springframework.waterworks.repository.CsvFileParser;
import com.nhnacademy.springframework.waterworks.repository.FileParser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateFeeTest {
    FileParser fileParser = new CsvFileParser();//DOC
    DataRead dataRead = new DataLoadService(fileParser); //DOC
    Calculate calculate = new CalculateFee(dataRead); //SUT
    @DisplayName("입력받은 값을 이용해 해당하는 구간의 unitPrice와 곱해서 최종 결과값이 제대로 나오고, 저장되는지 테스트")
    @Test
    void calculator() {
        List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();

        dataRead.dataLoadAndSave("Tariff_20220331.csv");
        int amount = 1000;
        calculate.calculator(amount);

        calculatedWaterFee.addAll(calculate.getCalculatedWaterFee());

        assertThat(calculatedWaterFee.size()).isEqualTo(103);
        assertThat(calculatedWaterFee.get(0).getNameOfCity()).isEqualTo(" 동두천시 ");
        assertThat(calculatedWaterFee.get(0).getFee()).isEqualTo(1530000);
        assertThat(calculatedWaterFee.get(102).getNameOfCity()).isEqualTo(" 고성군 ");
        assertThat(calculatedWaterFee.get(102).getFee()).isEqualTo(2170000);

    }
}
