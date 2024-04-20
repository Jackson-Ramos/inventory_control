package com.jcode.inventory_control.services;

import com.jcode.inventory_control.dto.PersonRequestDTO;
import com.jcode.inventory_control.dto.PersonResponseDTO;
import com.jcode.inventory_control.entities.Person;
import com.jcode.inventory_control.exceptions.ResourceNotFound;
import com.jcode.inventory_control.mapper.Mapper;
import com.jcode.inventory_control.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
	
	@Autowired
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// Get All People
	public ResponseEntity<List<PersonResponseDTO>> getAllPersons() {
		var listOfPeople = Mapper.parseListObjects(
				personRepository.findAll(), PersonResponseDTO.class
		);
		return ResponseEntity.status(HttpStatus.OK).body(listOfPeople);
	}
	
	// Get One Person
	public ResponseEntity<PersonResponseDTO> getOnePerson(String id) {
		var entity = personRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, PersonResponseDTO.class)
		);
	}
	
	// Create new People
	public ResponseEntity<PersonResponseDTO> createPerson(PersonRequestDTO personRequestDTO) {
		Person person = new Person(
				null,
				personRequestDTO.getCode(),
				personRequestDTO.getFirtName(),
				personRequestDTO.getLastName(),
				personRequestDTO.getPassword()
		);
		personRepository.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(person, PersonResponseDTO.class)
		);
	}
	
	// Update People
	public ResponseEntity<PersonResponseDTO> updatePerson(String id, PersonRequestDTO personRequestDTO) {
		var entity = personRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		Person person = new Person(
				null,
				personRequestDTO.getCode(),
				personRequestDTO.getFirtName(),
				personRequestDTO.getLastName(),
				personRequestDTO.getPassword()
		);
		personRepository.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(person, PersonResponseDTO.class)
		);
	}
	
	// Delete a Person
	public ResponseEntity<PersonResponseDTO> deletePerson(String id){
		var entity = personRepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		personRepository.delete(entity);
		return ResponseEntity.status(HttpStatus.OK).
				body(Mapper.parseObject(entity, PersonResponseDTO.class)
		);
	}
}
