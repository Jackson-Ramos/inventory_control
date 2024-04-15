package com.jack_dev.inventory_control.controllers;

import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable String id) {
		return productService.getOneProduct(id);
	}
	
	@PostMapping
	public ResponseEntity<ProductRequestDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		return productService.createNewProduct(productRequestDTO);
	}
}