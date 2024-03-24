package com.jack_dev.estoque.controllers;

import com.jack_dev.estoque.dto.AddressRequestDTO;
import com.jack_dev.estoque.entities.Address;
import com.jack_dev.estoque.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	public final AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping
	public ResponseEntity<List<AddressRequestDTO>> findAll() {
		return addressService.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<AddressRequestDTO> save(@RequestBody Address address){
		return addressService.save(address);
	}
}
