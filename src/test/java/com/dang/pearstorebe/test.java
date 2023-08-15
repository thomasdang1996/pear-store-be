package com.dang.pearstorebe;

import com.dang.pearstorebe.enums.ProductType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class test {
    @Test
    void test(){
        System.out.println(ProductType.geTypeByCode("PHN"));
    }
}
