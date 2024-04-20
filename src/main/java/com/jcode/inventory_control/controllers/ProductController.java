package com.jcode.inventory_control.controllers;

import com.jcode.inventory_control.dto.ProductRequestDTO;
import com.jcode.inventory_control.dto.ProductResponseDTO;
import com.jcode.inventory_control.openapi.ProductControllerOpenApi;
import com.jcode.inventory_control.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "Endpoints for Managing Products")
public class ProductController implements ProductControllerOpenApi {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<ProductResponseDTO> getOneProduct(@PathVariable String id) {
		return productService.getOneProduct(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		return productService.createNewProduct(productRequestDTO);
	}
}