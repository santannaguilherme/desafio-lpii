package com.storageClothes.utils.enuns;

public enum SizeEnum {

    P("P", 1),
    M("M", 2),
    G("G", 3);

    SizeEnum(String sizeName, int id) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public int getId() {
        return this.id;
    }

    public String getSizeName() {
        return this.sizeName;
    }

    private int id;
    private String sizeName;
}
