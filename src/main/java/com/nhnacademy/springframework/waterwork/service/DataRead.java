package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.WaterFee;
import java.util.Collection;

public interface DataRead {
    public void dataLoadAndSave();

    public Collection<WaterFee> findAll();
}
