package com.storageClothes.domain.entities;

public class ClotheType {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClotheTypeName() {
        return clotheTypeName;
    }

    public void setClotheTypeName(String clotheTypeName) {
        this.clotheTypeName = clotheTypeName;
    }

    private int id;
    private String clotheTypeName;
}
