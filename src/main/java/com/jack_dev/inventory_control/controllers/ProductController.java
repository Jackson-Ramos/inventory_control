package com.jack_dev.inventory_control.controllers;

import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Finds all products", description = "Finds all products",
			tags = {"Product"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {
									@Content(
											mediaType = "application/json",
											array = @ArraySchema(schema = @Schema(implementation = Product.class))
									)
							}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	public ResponseEntity<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Finds a products", description = "Finds a products",
			tags = {"Product"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = @Content(schema = @Schema(implementation = Product.class))
					),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content()),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	public ResponseEntity<Product> getOneProduct(@PathVariable String id) {
		return productService.getOneProduct(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Adds a new products",
			description = "Adds a new products by passing in a JSON",
			tags = {"Product"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = @Content(schema = @Schema(implementation = Product.class))
					),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content()),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	public ResponseEntity<ProductRequestDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		return productService.createNewProduct(productRequestDTO);
	}
}