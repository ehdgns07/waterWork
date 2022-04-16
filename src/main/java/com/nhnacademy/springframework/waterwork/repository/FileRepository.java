package com.nhnacademy.springframework.waterwork.repository;

import java.util.Collection;

public interface FileRepository {
    public void read();

    Collection<WaterFee> findAll();
}
