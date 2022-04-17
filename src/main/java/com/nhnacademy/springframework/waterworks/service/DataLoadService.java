package com.nhnacademy.springframework.waterworks.service;

import com.nhnacademy.springframework.waterworks.repository.FileParser;
import com.nhnacademy.springframework.waterworks.repository.WaterFee;
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
    public boolean dataLoadAndSave(String path){
        waterFee.clear();
        fileParser.read(path);
        waterFee.addAll(fileParser.findAll());
        return true;
    }

    @Override
    public Collection<WaterFee> findAll(){
        return waterFee;
    }
}
