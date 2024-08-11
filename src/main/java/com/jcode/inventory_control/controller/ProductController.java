package com.jcode.inventory_control.controller;

import com.jcode.inventory_control.entities.product.ProductRequestDTO;
import com.jcode.inventory_control.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO product) {
        return productService.saveProduct(product);
    }
}
