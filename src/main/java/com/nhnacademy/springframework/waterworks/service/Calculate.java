package com.nhnacademy.springframework.waterworks.service;

import com.nhnacademy.springframework.waterworks.repository.CalculatedWaterFee;
import java.util.List;

public interface Calculate {
    public void calculator(long amount);

    public List<CalculatedWaterFee> getCalculatedWaterFee();
}
