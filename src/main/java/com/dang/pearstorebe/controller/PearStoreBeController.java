package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.dto.AddNewProductRequest;
import com.dang.pearstorebe.dto.CreateAccountRequest;
import com.dang.pearstorebe.dto.ProductsByTypeDto;
import com.dang.pearstorebe.service.AccountService;
import com.dang.pearstorebe.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pear-store-be/product")
@RequiredArgsConstructor
public class PearStoreBeController {

    private final ProductService productService;

    @PostMapping("product")
    public ResponseEntity<AddNewProductRequest> addNewProduct(@RequestBody AddNewProductRequest addNewProductRequest) {
        return ResponseEntity.ok(productService.addNewProduct(addNewProductRequest));
    }

    @CrossOrigin
    @GetMapping("getProductNames")
    public ResponseEntity<ProductsByTypeDto> getProductNames(@RequestParam String productTypeCode) {
        return ResponseEntity.ok(productService.getProductNames(productTypeCode));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<AddNewProductRequest> getProduct(@RequestParam long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }
}
