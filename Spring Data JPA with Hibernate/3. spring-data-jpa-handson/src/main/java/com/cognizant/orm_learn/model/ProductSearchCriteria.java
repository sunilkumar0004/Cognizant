package com.cognizant.orm_learn.model;

import java.math.BigDecimal;

public class ProductSearchCriteria {
    private String brand;
    private BigDecimal maxPrice;
    private Integer ramSize;
    private String os;
    private Double minRating;

    public ProductSearchCriteria() {
    }

    public ProductSearchCriteria(String brand, BigDecimal maxPrice, Integer ramSize, String os, Double minRating) {
        this.brand = brand;
        this.maxPrice = maxPrice;
        this.ramSize = ramSize;
        this.os = os;
        this.minRating = minRating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Double getMinRating() {
        return minRating;
    }

    public void setMinRating(Double minRating) {
        this.minRating = minRating;
    }
}
