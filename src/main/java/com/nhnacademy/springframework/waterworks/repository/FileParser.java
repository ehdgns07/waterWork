package com.nhnacademy.springframework.waterworks.repository;

import java.util.Collection;

public interface FileParser {
    public void read(String path);

    Collection<WaterFee> findAll();
}
