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
									mediaType = "appçication/JSON",
									array = @ArraySchema(schema = @Schema(implementation = PersonResponseDTO.class)))
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content()),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content()),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content()),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<List<PersonResponseDTO>> getAllPersons();
	
	public ResponseEntity<PersonResponseDTO> getOnePerson(String id);
	
	public ResponseEntity<PersonResponseDTO> CreatePerson(PersonRequestDTO personRequestDTO);
	
	public ResponseEntity<PersonResponseDTO> updatePerson(String id, PersonRequestDTO personRequestDTO);
	
	public ResponseEntity<PersonResponseDTO> deletePerson(String id);
}
