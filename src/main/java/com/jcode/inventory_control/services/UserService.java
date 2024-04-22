package com.jcode.inventory_control.services;

import com.jcode.inventory_control.dto.UserRequestDTO;
import com.jcode.inventory_control.dto.UserResponseDTO;
import com.jcode.inventory_control.entities.User;
import com.jcode.inventory_control.exceptions.ResourceNotFound;
import com.jcode.inventory_control.mapper.Mapper;
import com.jcode.inventory_control.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<List<UserResponseDTO>> getAllPersons() {
		var listOfPeople = Mapper.parseListObjects(
				userRepository.findAll(), UserResponseDTO.class
		);
		return ResponseEntity.status(HttpStatus.OK).body(listOfPeople);
	}

	public ResponseEntity<UserResponseDTO> getOnePerson(Integer id) {
		var entity = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, UserResponseDTO.class)
		);
	}

	public ResponseEntity<UserResponseDTO> createPerson(UserRequestDTO userRequestDTO) {
		User user = new User(userRequestDTO);
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	public ResponseEntity updatePerson(Integer id, UserRequestDTO userRequestDTO) {
		var entity = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		User user = new User(userRequestDTO);
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	public ResponseEntity<UserResponseDTO> deletePerson(Integer id){
		var entity = userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		userRepository.delete(entity);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var person = userRepository.findByUserName(username);
		if (person == null) {
			return person;
		}
		else {
			throw new UsernameNotFoundException("The Username : " + username + " Not Found");
		}
	}
}
