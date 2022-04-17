package com.nhnacademy.springframework.waterworks.config;

import com.nhnacademy.springframework.waterworks.BootStrap;
import com.nhnacademy.springframework.waterworks.repository.CsvFileParser;
import com.nhnacademy.springframework.waterworks.repository.FileParser;
import com.nhnacademy.springframework.waterworks.repository.JsonFileParser;
import com.nhnacademy.springframework.waterworks.service.Calculate;
import com.nhnacademy.springframework.waterworks.service.CalculateFee;
import com.nhnacademy.springframework.waterworks.service.DataRead;
import com.nhnacademy.springframework.waterworks.service.DataLoadService;
import com.nhnacademy.springframework.waterworks.service.LoggingResultService;
import com.nhnacademy.springframework.waterworks.service.LogingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.type.AnnotatedTypeMetadata;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.nhnacademy.springframework")
public class MainConfigFile {

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
    public DataRead dataRead(@Qualifier("json") FileParser fileParserA, @Qualifier("csv") FileParser fileParserB) {
        if(BootStrap.fileExtention[2].equals("json")) {
            return new DataLoadService(fileParserA);
        }
        if(BootStrap.fileExtention[2].equals("csv")){
            return new DataLoadService(fileParserB);
        }
        return null;
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
