package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import com.nhnacademy.springframework.waterwork.repository.WaterFee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DataReadService implements DataRead{
    FileRepository fileRepository;
    List<WaterFee> waterFee = new ArrayList<>();

    public DataReadService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @Override
    public void dataLoadAndSave(){
        waterFee.clear();
        waterFee.addAll(fileRepository.findAll());
    }

    @Override
    public Collection<WaterFee> findAll(){
        return waterFee;
    }
}
