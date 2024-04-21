package com.jcode.inventory_control.openapi;

import com.jcode.inventory_control.dto.PersonRequestDTO;
import com.jcode.inventory_control.dto.PersonResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "People", description = "Product-related methods")
public interface PersonControllerOpenApi {
	
	@Operation(
			summary = "Finds a People",
			description = "search for all people",
			tags = {"People"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PersonResponseDTO.class))
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	ResponseEntity<List<PersonResponseDTO>> getAllPersons();
	
	@Operation(
			summary = "Get one Person",
			description = "Gets a user based on the ID entered by the user",
			tags = {"People"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = PersonResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<PersonResponseDTO> getOnePerson(Integer id);
	
	@Operation(
			summary = "adds a new Person",
			description = "Adds a new products by passing in a JSON",
			tags = {"People"},
			responses = {
					@ApiResponse(
							description = "Created",
							responseCode = "201",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = PersonResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unautorizad", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbildden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<PersonResponseDTO> CreatePerson(PersonRequestDTO personRequestDTO);
	
	@Operation(
			summary = "Update person",
			description = "update an existing person by passing a JSON",
			tags = {"People"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = PersonResponseDTO.class)
							)
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Fobidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
				
			}
	)
	ResponseEntity<PersonResponseDTO> updatePerson(Integer id, PersonRequestDTO personRequestDTO);
	
	@Operation(
			summary = "Delete a Person",
			description = "delete a person based on passed ID",
			tags = {"People"},
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = PersonResponseDTO.class)
							)
					),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	ResponseEntity<PersonResponseDTO> deletePerson(Integer id);
}
