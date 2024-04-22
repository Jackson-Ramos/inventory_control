package com.jcode.inventory_control.controllers;

import com.jcode.inventory_control.dto.UserRequestDTO;
import com.jcode.inventory_control.dto.UserResponseDTO;
import com.jcode.inventory_control.openapi.UserControllerOpenApi;
import com.jcode.inventory_control.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/person")
public class UserController implements UserControllerOpenApi {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<UserResponseDTO>> getAllPersons() {
		return userService.getAllPersons();
	}

	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<UserResponseDTO> getOnePerson(@PathVariable Integer id) {
		return userService.getOnePerson(id);
	}

	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<UserResponseDTO> CreatePerson(@RequestBody UserRequestDTO userRequestDTO) {
		return userService.createPerson(userRequestDTO);
	}

	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<UserResponseDTO> updatePerson(@PathVariable Integer id, @RequestBody UserRequestDTO userRequestDTO) {
		return userService.updatePerson(id, userRequestDTO);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<UserResponseDTO> deletePerson(@PathVariable Integer id) {
		return userService.deletePerson(id);
	}
}
