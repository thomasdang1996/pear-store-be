package com.dang.pearstorebe.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductType {
    PHONE("PHN"),

    TABLET("TBLT");

    private final String code;

    ProductType(String code) {
        this.code = code;
    }

    public static ProductType geTypeByCode(String code) {
        return Arrays
                .stream(values())
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ProductType not found: " + code));
    }

}
