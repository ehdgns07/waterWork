package com.nhnacademy.springframework.waterwork.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CsvFileParserTest {
    @DisplayName("csv파일을 읽어오고 제대로 저장되는지 테스트")
    @Test
    void read() {
        final Log log = LogFactory.getLog(CsvFileParser.class);
        List<WaterFee> waterFeeList = new ArrayList<>();

        String line = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("./Tariff_20220331.csv")))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith(" 순번 ")) {
                    continue;
                }
                String StrArr[] = line.split(",");
                waterFeeList.add(new WaterFee(Integer.parseInt(StrArr[0]), StrArr[1], StrArr[2],
                    Integer.parseInt(StrArr[3]), Integer.parseInt(StrArr[4]),
                    Integer.parseInt(StrArr[5])
                    , Integer.parseInt(StrArr[6])));
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("파일이 없습니다!");
        }
        assertThat(waterFeeList.size()).isEqualTo(303);
        assertThat(waterFeeList.get(0).getNameOfCity()).isEqualTo(" 동두천시 ");
        assertThat(waterFeeList.get(0).getUnitPrice()).isEqualTo(690);
        assertThat(waterFeeList.get(302).getNameOfCity()).isEqualTo(" 고성군 ");
        assertThat(waterFeeList.get(302).getUnitPrice()).isEqualTo(2170);
    }
}
