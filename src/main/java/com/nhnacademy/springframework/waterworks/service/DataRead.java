package com.nhnacademy.springframework.waterworks.service;

import com.nhnacademy.springframework.waterworks.repository.WaterFee;
import java.util.Collection;

public interface DataRead {
    public boolean dataLoadAndSave(String path);

    public Collection<WaterFee> findAll();
}
