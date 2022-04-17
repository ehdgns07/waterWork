package com.nhnacademy.springframework.waterwork.repository;

import java.util.Collection;

public interface FileParser {
    public void read(String path);

    Collection<WaterFee> findAll();
}
