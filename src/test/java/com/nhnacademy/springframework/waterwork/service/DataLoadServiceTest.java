package com.nhnacademy.springframework.waterwork.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springframework.waterwork.config.MainConfigFile;
import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileParser;
import com.nhnacademy.springframework.waterwork.repository.WaterFee;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MainConfigFile.class)
class DataLoadServiceTest {

    FileParser fileParser = new CsvFileParser();

    List<WaterFee> waterFee = new ArrayList<>();

    @Test
    void dataLoadAndSave() {
        fileParser.read("./Tariff_20220331.csv");
        waterFee.addAll(fileParser.findAll());
        assertThat(waterFee.size()).isEqualTo(303);
        }
    }
