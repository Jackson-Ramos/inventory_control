package com.jack_dev.inventory_control.openapi;

import com.jack_dev.inventory_control.dto.PersonRequestDTO;
import com.jack_dev.inventory_control.dto.PersonResponseDTO;
import com.jack_dev.inventory_control.entities.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "People", description = "methods related to employee creation, update, deletion and viewing")
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
	public ResponseEntity<List<PersonResponseDTO>> getAllPersons();
	
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
	public ResponseEntity<PersonResponseDTO> getOnePerson(String id);
	
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
					@ApiResponse(description = "400", responseCode = "Bad Request", content = @Content()),
					@ApiResponse(description = "Unautorizad", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Forbildden", responseCode = "403", content = @Content()),
					@ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content())
			}
	)
	public ResponseEntity<PersonResponseDTO> CreatePerson(PersonRequestDTO personRequestDTO);
	
	@Operation(
			summary = "Update person",
			description = "update an existing person by passing a JSON",
			tags = {"People"},
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(
									mediaType = "Application/json",
									schema = @Schema(implementation = PersonResponseDTO.class)
							)
					),
				
			}
	)
	public ResponseEntity<PersonResponseDTO> updatePerson(String id, PersonRequestDTO personRequestDTO);
	
	public ResponseEntity<PersonResponseDTO> deletePerson(String id);
}
