package com.nhnacademy.springframework.waterwork.repository;

public class CalculatedWaterFee {

    private String nameOfCity = null;
    private String sector = null;
    private int unitPrice = 0;
    private long fee = 0;

    public CalculatedWaterFee(String nameOfCity, String sector, int unitPrice, long fee){
        this.nameOfCity = nameOfCity;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.fee = fee;
    }

    public long getFee() {
        return fee;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public String toString() {
        return "CalculatedWaterFee{" +
            "nameOfCity='" + nameOfCity + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice=" + unitPrice +
            ", fee=" + fee +
            '}';
    }
}
