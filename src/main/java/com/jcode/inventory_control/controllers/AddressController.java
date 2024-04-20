package com.jcode.inventory_control.controllers;

import com.jcode.inventory_control.dto.AddressRequestDTO;
import com.jcode.inventory_control.dto.AddressResponseDTO;
import com.jcode.inventory_control.openapi.AddressControllerOpenApi;
import com.jcode.inventory_control.services.AddressService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/address")
public class AddressController implements AddressControllerOpenApi {
	
	private final AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<AddressResponseDTO>> findAll() {
		return addressService.getAllAddress();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressResponseDTO> findById(@PathVariable String id) {
		return addressService.getOneAddress(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<AddressResponseDTO> save(@RequestBody AddressRequestDTO addressRequestDTO) {
		return addressService.saveAddress(addressRequestDTO);
	}
	
}
