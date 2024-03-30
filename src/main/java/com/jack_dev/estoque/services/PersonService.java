package com.jack_dev.estoque.services;

import com.jack_dev.estoque.dto.PersonRequestDTO;
import com.jack_dev.estoque.entities.Person;
import com.jack_dev.estoque.exceptions.ResourceNotFound;
import com.jack_dev.estoque.mapper.Mapper;
import com.jack_dev.estoque.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
	
	@Autowired
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// Get All People
	public ResponseEntity<List<PersonRequestDTO>> getAllPersons() {
		var listOfPeople = Mapper.parseListObjects(
				personRepository.findAll(), PersonRequestDTO.class
		);
		return ResponseEntity.status(HttpStatus.OK).body(listOfPeople);
	}
	
	// Get One People
	public ResponseEntity<PersonRequestDTO> getOnePerson(UUID id) {
		var entity = personRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, PersonRequestDTO.class)
		);
	}
	
	// Create new People
	public ResponseEntity<PersonRequestDTO> createNewPerson(Person person) {
		var entity = Mapper.parseObject(
				personRepository.save(person), PersonRequestDTO.class
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
	// Update People
	public ResponseEntity<PersonRequestDTO> updatePerson(UUID id, Person person) {
		var entity = personRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		personRepository.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(entity, PersonRequestDTO.class)
		);
	}
	
	// Delete a Person
	public ResponseEntity<PersonRequestDTO> deletePerson(UUID id){
		var entity = personRepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		personRepository.delete(entity);
		return ResponseEntity.status(HttpStatus.OK).
				body(Mapper.parseObject(entity, PersonRequestDTO.class)
		);
	}
}
