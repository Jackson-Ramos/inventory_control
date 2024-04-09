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
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Set<ProductRequestDTO>> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductRequestDTO> getOneProduct(@PathVariable String id) {
		return productService.getOneProduct(id);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<ProductRequestDTO> CreateNewProduct(@RequestBody Product product) {
		return productService.createNewProduct(product);
	}
	
}