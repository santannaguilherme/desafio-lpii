package com.estoqueRoupas.utils.enuns;

public enum ColorEnum {

    YELLOW("Amarelo", 1),
    BLUE("Azul", 2),
    RED("Vermelho", 3);

    ColorEnum(String colorName, int id) {
        this.id = id;
        this.colorName = colorName;
    }

    public String getColorName() {
        return this.colorName;
    }

    public int getId() {
        return this.id;
    }

    private final String colorName;
    private final int id;
}
