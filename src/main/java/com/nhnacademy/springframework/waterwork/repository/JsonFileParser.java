package com.nhnacademy.springframework.waterwork.repository;

import static java.lang.Integer.parseInt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JsonFileParser implements FileParser{
    private List<WaterFee> waterFeeList = new ArrayList<>();
    private static final Log log = LogFactory.getLog(JsonFileParser.class);
    @Override
    public void read(String path) {
        ObjectMapper objectMapper = new ObjectMapper();


        try( BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("./Tariff_20220331.json")))){
            TypeReference<List<HashMap<String,String>>> typeRef = new TypeReference<>(){};

            List<HashMap<String,String>> jsonParsingList = objectMapper.readValue(br , typeRef);

            jsonParsingList.stream().forEach(stringObjectHashMap -> waterFeeList.add(new WaterFee(parseInt(stringObjectHashMap.get("순번"))
                ,stringObjectHashMap.get("지자체명"), stringObjectHashMap.get("업종"), parseInt(stringObjectHashMap.get("단계"))
                , parseInt(stringObjectHashMap.get("구간시작(세제곱미터)")), parseInt( stringObjectHashMap.get("구간끝(세제곱미터)"))
                , parseInt(stringObjectHashMap.get("구간금액(원)")))));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    @Override
    public Collection<WaterFee> findAll() {
        return waterFeeList;
    }
}