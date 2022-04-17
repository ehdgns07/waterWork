package com.nhnacademy.springframework.waterwork.config;

import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import com.nhnacademy.springframework.waterwork.service.Calculate;
import com.nhnacademy.springframework.waterwork.service.CalculateFee;
import com.nhnacademy.springframework.waterwork.service.DataRead;
import com.nhnacademy.springframework.waterwork.service.DataReadService;
import com.nhnacademy.springframework.waterwork.service.LogingResultService;
import com.nhnacademy.springframework.waterwork.service.LogingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.nhnacademy.springframework")
public class MainConfigFile {

    @Bean
    public FileRepository fileRepository() {
        return new CsvFileParser();
    }

    @Bean
    public DataRead dataRead(FileRepository fileRepository) {
        return new DataReadService(fileRepository);
    }

    @Bean
    public Calculate calculate(DataRead dataRead) {
        return new CalculateFee(dataRead);
    }


    @Bean
    public LogingService logingService(Calculate calculate) {
        return new LogingResultService(calculate);
    }

}
