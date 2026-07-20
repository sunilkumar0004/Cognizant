package com.cognizant.orm_learn.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pr_id")
    private int id;

    @Column(name="pr_name")
    private String name;

    @Column(name="pr_brand")
    private String brand;

    @Column(name="pr_price")
    private BigDecimal price;

    @Column(name="pr_ram_size")
    private int ramSize;

    @Column(name="pr_hd_size")
    private int hdSize;

    @Column(name="pr_os")
    private String os;

    @Column(name="pr_weight")
    private double weight;

    @Column(name="pr_cpu")
    private String cpu;

    @Column(name="pr_rating")
    private double rating;

    public Product() {
    }

    public Product(String name, String brand, BigDecimal price, int ramSize, int hdSize, String os, double weight, String cpu, double rating) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.ramSize = ramSize;
        this.hdSize = hdSize;
        this.os = os;
        this.weight = weight;
        this.cpu = cpu;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getHdSize() {
        return hdSize;
    }

    public void setHdSize(int hdSize) {
        this.hdSize = hdSize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price 
                + ", RAM=" + ramSize + "GB, HD=" + hdSize + "GB, OS=" + os + ", CPU=" + cpu + "]";
    }
}
