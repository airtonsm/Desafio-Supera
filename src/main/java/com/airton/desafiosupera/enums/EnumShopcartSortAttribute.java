package com.airton.desafiosupera.enums;

public enum EnumSortAttribute {

    PRICE("PRICE"),
    SCORE("SCORE"),
    NAME("NAME");

    private String sortAttribute;

    EnumSortAttribute(String sortAttribute) {
        this.sortAttribute = sortAttribute;
    }

    public String getSortAttribute() {
        return sortAttribute;
    }
}
