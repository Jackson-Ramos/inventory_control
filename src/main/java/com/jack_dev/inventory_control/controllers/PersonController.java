package com.jack_dev.inventory_control.controllers;

import com.jack_dev.inventory_control.dto.PersonRequestDTO;
import com.jack_dev.inventory_control.entities.Person;
import com.jack_dev.inventory_control.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<PersonRequestDTO>> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonRequestDTO> getOnePerson(@PathVariable UUID id) {
		return personService.getOnePerson(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonRequestDTO> CreateNewPerson(@RequestBody Person person) {
		return personService.createNewPerson(person);
	}
	
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonRequestDTO> updatePerson(@PathVariable UUID id, @RequestBody Person person){
		return personService.updatePerson(id, person);
	}
	
	@DeleteMapping(value = "/{id}",
	produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PersonRequestDTO>delete(@PathVariable UUID id){
		return personService.deletePerson(id);
	}
}
