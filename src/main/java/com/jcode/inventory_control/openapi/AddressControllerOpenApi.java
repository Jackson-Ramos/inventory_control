package com.jcode.inventory_control.openapi;

import com.jcode.inventory_control.dto.AddressRequestDTO;
import com.jcode.inventory_control.dto.AddressResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Address", description = "Address-related methods")
public interface AddressControllerOpenApi {
	
	@Operation(
			summary = "Finds a Addresses",
			description = "search for all Addresses",
			tags = {"Address"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = AddressResponseDTO.class))
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	ResponseEntity<List<AddressResponseDTO>> findAll();
	
	@Operation(
			summary = "Get one Address",
			description = "Gets a Address based on the ID entered by the user",
			tags = {"Address"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = AddressResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<AddressResponseDTO> findById(String id);
	
	@Operation(
			summary = "adds a new Address",
			description = "Adds a new Addresses by passing in a JSON",
			tags = {"Address"},
			responses = {
					@ApiResponse(
							description = "Created",
							responseCode = "201",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = AddressResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unautorizad", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbildden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<AddressResponseDTO> save(AddressRequestDTO addressRequestDTO);
}
