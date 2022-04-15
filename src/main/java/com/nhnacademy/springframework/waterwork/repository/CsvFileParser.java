package com.nhnacademy.springframework.waterwork.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CsvFileParser implements FileRepository{
private static final Log log = LogFactory.getLog(CsvFileParser.class);
private List<WaterFee> waterFeeList = new ArrayList<>();
    public void read(){
        String line = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/score.csv")))) {
            while((line = br.readLine()) != null){
                if(line.startsWith("순번")){
                    continue;
                }
                String StrArr[] = line.split(",");
                    waterFeeList.add(new WaterFee(Integer.parseInt(StrArr[0]),StrArr[1],StrArr[2],
                        Integer.parseInt(StrArr[3]),Integer.parseInt(StrArr[4]),Integer.parseInt(StrArr[5])
                        , Long.parseLong(StrArr[6]),Long.parseLong(StrArr[7])));
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("파일이 없습니다!");
        }
    }


}
