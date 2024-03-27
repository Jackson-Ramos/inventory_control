package com.jack_dev.estoque.controllers;

import com.jack_dev.estoque.dto.AddressRequestDTO;
import com.jack_dev.estoque.entities.Address;
import com.jack_dev.estoque.services.AddressService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	public final AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddressRequestDTO>> findAll() {
		return addressService.getAllAddress();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressRequestDTO> findById(@PathParam(value = "id") UUID id) {
		return addressService.getOneAddress(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressRequestDTO> save(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PutMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressRequestDTO> update(@PathParam(value = "id") UUID id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressRequestDTO> delete(@PathParam(value = "id") UUID id) {
		return addressService.deleteAddress(id);
	}
}
