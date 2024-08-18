package com.jcode.inventory_control.controller;

import com.jcode.inventory_control.entities.product.ProductRequestDTO;
import com.jcode.inventory_control.entities.product.ProductResponseDTO;
import com.jcode.inventory_control.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Void> addProduct(@RequestBody ProductRequestDTO product) {
        return productService.save(product);
    }

    @GetMapping()
    public ResponseEntity<Set<ProductResponseDTO>> getAllProducts() {
        return productService.findAll();
    }
}
