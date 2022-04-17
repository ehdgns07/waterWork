package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import java.util.List;

public interface Calculate {
    public void calculator(long amount);

    public List<CalculatedWaterFee> getCalculatedWaterFee();
}
