package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DataReadService implements DataRead{
    FileRepository fileRepository;
    @Autowired
    public DataReadService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @Override
    @Bean
    public void dataRead(){
        fileRepository.read();
    }
}
