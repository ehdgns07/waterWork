package com.nhnacademy.springframework.waterwork.config;

import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileParser;
import com.nhnacademy.springframework.waterwork.repository.JsonFileParser;
import com.nhnacademy.springframework.waterwork.service.Calculate;
import com.nhnacademy.springframework.waterwork.service.CalculateFee;
import com.nhnacademy.springframework.waterwork.service.DataRead;
import com.nhnacademy.springframework.waterwork.service.DataLoadService;
import com.nhnacademy.springframework.waterwork.service.LoggingResultService;
import com.nhnacademy.springframework.waterwork.service.LogingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.nhnacademy.springframework")
public class MainConfigFile {

    @Bean
    public FileParser fileParser() {
        return new CsvFileParser();
    }

    @Bean
    @Qualifier("json")
    public FileParser jsonFileParser(){
        return new JsonFileParser();
    }

    @Bean
    @Qualifier("csv")
    public FileParser csvFileParser() {
        return new CsvFileParser();
    }

    @Bean
    public DataRead dataRead(@Qualifier("json") FileParser fileParser) {
        return new DataLoadService(fileParser);
    }

    @Bean
    public Calculate calculate(DataRead dataRead) {
        return new CalculateFee(dataRead);
    }


    @Bean
    public LogingService logingService(Calculate calculate) {
        return new LoggingResultService(calculate);
    }




}
