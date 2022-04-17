package com.nhnacademy.springframework.waterworks;

import com.nhnacademy.springframework.waterworks.config.MainConfigFile;
import com.nhnacademy.springframework.waterworks.repository.FileParser;
import com.nhnacademy.springframework.waterworks.service.Calculate;
import com.nhnacademy.springframework.waterworks.service.DataRead;
import com.nhnacademy.springframework.waterworks.service.LogingService;
import java.sql.Array;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    static Log log = LogFactory.getLog(BootStrap.class);
    public static String[] fileExtention;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long amount = 0;
        String path = null;
        log.info("json-> j, csv -> c");
        String selection = scan.nextLine();
        if(selection.equals("c")) {
            path = "./Tariff_20220331.csv";
        }

            path = "./Tariff_20220331.json";


        fileExtention = path.split("\\.");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            MainConfigFile.class)) {
            while(true) {
                log.info("0은 종료\n");
                log.info(">");

                amount = scan.nextInt();
                if(amount == 0){
                    break;
                }
//                context.getBean("fileParser", FileParser.class).read(path);
                context.getBean("dataRead", DataRead.class).dataLoadAndSave(path);
                context.getBean("calculate", Calculate.class).calculator(amount);
                context.getBean("logingService", LogingService.class).printingResult();
            }
        }
    }
}
