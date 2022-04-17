package com.nhnacademy.springframework.waterwork;

import com.nhnacademy.springframework.waterwork.config.MainConfigFile;
import com.nhnacademy.springframework.waterwork.repository.FileParser;
import com.nhnacademy.springframework.waterwork.service.Calculate;
import com.nhnacademy.springframework.waterwork.service.DataRead;
import com.nhnacademy.springframework.waterwork.service.LogingService;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    static Log log = LogFactory.getLog(BootStrap.class);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = 0;
        String path = "./Tariff_20220331.csv";
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            MainConfigFile.class)) {
            while(true) {
                log.info("0은 종료\n");
                log.info(">");

                amount = scan.nextInt();
                if(Objects.equals(amount, 0)){
                    break;
                }
                context.getBean("fileRepository", FileParser.class).read(path);
                context.getBean("dataRead", DataRead.class).dataLoadAndSave();
                context.getBean("calculate", Calculate.class).calculator(amount);
                context.getBean("logingService", LogingService.class).printingResult();
            }
        }
    }
}
