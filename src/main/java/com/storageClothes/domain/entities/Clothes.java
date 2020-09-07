package com.storageClothes.domain.entities;

import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.SizeEnum;

import java.util.Date;

public class Clothes {
    private int code;
    private Date entryDay;
    private Brand brand;
    private double priceTag;
    private double paidPrice;
    private double suggestedPrice;
    private ColorEnum color;
    private SizeEnum size;

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public int getCode() {
        return code;
    }

    public Date getEntryDay() {
        return entryDay;
    }

    public void setEntryDay(Date entryDay) {
        this.entryDay = entryDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(double priceTag) {
        this.priceTag = priceTag;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public double getMarginPrice() {
        return paidPrice*2;
    }

    public double getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(double suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }
}