package com.jcode.inventory_control.openapi;

import com.jcode.inventory_control.dto.ProductRequestDTO;
import com.jcode.inventory_control.dto.ProductResponseDTO;
import com.jcode.inventory_control.entities.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Product", description = "Product-related methods")
public interface ProductControllerOpenApi {
	
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
	ResponseEntity<List<ProductResponseDTO>> getAllProducts();
	
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
	ResponseEntity<ProductResponseDTO> getOneProduct(String id);
	
	@Operation(summary = "Adds a new products",
			description = "Adds a new products by passing in a JSON",
			tags = {"Product"},
			responses = {
					@ApiResponse(description = "Created", responseCode = "201",
							content = @Content(schema = @Schema(implementation = Product.class))
					),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content()),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<ProductResponseDTO> createProduct(ProductRequestDTO productRequestDTO);
}
