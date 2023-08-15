package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.dto.ProductDto;
import com.dang.pearstorebe.dto.ProductsByTypeDto;
import com.dang.pearstorebe.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pear-store-be/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addNewProduct(productDto));
    }

    @CrossOrigin
    @GetMapping("getProductNames")
    public ResponseEntity<ProductsByTypeDto> getProductNames(@RequestParam String productTypeCode) {
        return ResponseEntity.ok(productService.getProductNames(productTypeCode));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<ProductDto> getProduct(@RequestParam long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }
}
