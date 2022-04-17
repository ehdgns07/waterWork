package com.nhnacademy.springframework.waterwork.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class jsonFileParserTest {

        JsonFileParser jsonFileParser = new JsonFileParser();
        @DisplayName("json파일 로드하고 파싱하는 테스트")
    @Test
    void read() {
        List<WaterFee> waterFeeList = new ArrayList<>();
        jsonFileParser.read("./Tariff_20220331.csv");
        waterFeeList = jsonFileParser.findAll().stream().collect(Collectors.toList());
        assertThat(waterFeeList).isNotNull();
        assertThat(waterFeeList.get(0).getNameOfCity()).isEqualTo("동두천시");
        assertThat(waterFeeList.get(0).getUnitPrice()).isEqualTo(690);
        assertThat(waterFeeList.get(302).getNameOfCity()).isEqualTo("고성군");
        assertThat(waterFeeList.get(302).getUnitPrice()).isEqualTo(2170);
    }
}