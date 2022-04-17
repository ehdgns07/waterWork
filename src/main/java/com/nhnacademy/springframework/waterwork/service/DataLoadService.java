package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.FileParser;
import com.nhnacademy.springframework.waterwork.repository.WaterFee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataLoadService implements DataRead{
    FileParser fileParser;
    List<WaterFee> waterFee = new ArrayList<>();

    public DataLoadService(FileParser fileParser){
        this.fileParser = fileParser;
    }

    @Override
    public void dataLoadAndSave(){
        waterFee.clear();
        waterFee.addAll(fileParser.findAll());
    }

    @Override
    public Collection<WaterFee> findAll(){
        return waterFee;
    }
}
