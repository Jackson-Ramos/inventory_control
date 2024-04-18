package com.jack_dev.inventory_control.controllers;

import com.jack_dev.inventory_control.dto.PersonRequestDTO;
import com.jack_dev.inventory_control.dto.PersonResponseDTO;
import com.jack_dev.inventory_control.entities.Person;
import com.jack_dev.inventory_control.openapi.PersonControllerOpenApi;
import com.jack_dev.inventory_control.services.PersonService;
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
@RequestMapping("/person")
public class PersonController implements PersonControllerOpenApi {
	
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<PersonResponseDTO>> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonResponseDTO> getOnePerson(@PathVariable String id) {
		return personService.getOnePerson(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonResponseDTO> CreatePerson(@RequestBody PersonRequestDTO personRequestDTO) {
		return personService.createPerson(personRequestDTO);
	}
	
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable String id, @RequestBody PersonRequestDTO personRequestDTO) {
		return personService.updatePerson(id, personRequestDTO);
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonResponseDTO> deletePerson(@PathVariable String id) {
		return personService.deletePerson(id);
	}
}
