package com.nhnacademy.springframework.waterwork.config;

import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import com.nhnacademy.springframework.waterwork.service.CalculateFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ConfigFile {

        @Bean
        public FileRepository csvFileParser(){
            return new CsvFileParser();
        }

        @Bean
        public CalculateFee calculateFee (FileRepository fileRepository){
            return new CalculateFee(fileRepository);
        }

}
