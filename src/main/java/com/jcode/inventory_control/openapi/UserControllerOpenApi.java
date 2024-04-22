package com.jcode.inventory_control.openapi;

import com.jcode.inventory_control.dto.UserRequestDTO;
import com.jcode.inventory_control.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "User", description = "Product-related methods")
public interface UserControllerOpenApi {
	
	@Operation(
			summary = "Finds a User",
			description = "search for all User",
			tags = {"User"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = UserResponseDTO.class))
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	ResponseEntity<List<UserResponseDTO>> getAllPersons();
	
	@Operation(
			summary = "Get one User",
			description = "Gets a user based on the ID entered by the user",
			tags = {"User"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = UserResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<UserResponseDTO> getOnePerson(Integer id);
	
	@Operation(
			summary = "adds a new User",
			description = "Adds a new User by passing in a JSON",
			tags = {"User"},
			responses = {
					@ApiResponse(
							description = "Created",
							responseCode = "201",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = UserResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unautorizad", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbildden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<UserResponseDTO> CreatePerson(UserRequestDTO userRequestDTO);
	
	@Operation(
			summary = "Update User",
			description = "update an existing User by passing a JSON",
			tags = {"User"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = UserResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Fobidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
				
			}
	)
	ResponseEntity<UserResponseDTO> updatePerson(Integer id, UserRequestDTO userRequestDTO);
	
	@Operation(
			summary = "Delete a Person",
			description = "delete a User based on passed ID",
			tags = {"User"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = UserResponseDTO.class)
							)
					),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<UserResponseDTO> deletePerson(Integer id);
}
