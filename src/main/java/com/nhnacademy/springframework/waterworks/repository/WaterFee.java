package com.nhnacademy.springframework.waterworks.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WaterFee {
    private int orderNumber = 0;
    private String nameOfCity = null;
    private String sector = null;
    private int level = 0;
    private int sectionStart = 0;
    private int sectionEnd = 0;
    private int unitPrice = 0;

    public WaterFee(@JsonProperty("순번") int orderNumber,@JsonProperty("지자체명") String nameOfCity,@JsonProperty("업종") String sector,@JsonProperty("단계") int level,
                    @JsonProperty("구간시작(세제곱미터)") int sectionStart,@JsonProperty("구간끝(세제곱미터)") int sectionEnd, @JsonProperty("구간금액(원)")int unitPrice
                    ){
        this.orderNumber = orderNumber;
        this.nameOfCity = nameOfCity;
        this.sector = sector;
        this.level = level;
        this.sectionStart = sectionStart;
        this.sectionEnd = sectionEnd;
        this.unitPrice = unitPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public String getSector() {
        return sector;
    }

    public int getSectionStart() {
        return sectionStart;
    }

    public int getSectionEnd() {
        return sectionEnd;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getLevel() {
        return level;
    }

}
