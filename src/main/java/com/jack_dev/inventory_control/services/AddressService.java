package com.jack_dev.inventory_control.services;

import com.jack_dev.inventory_control.dto.AddressRequestDTO;
import com.jack_dev.inventory_control.entities.Address;
import com.jack_dev.inventory_control.exceptions.ResourceNotFound;
import com.jack_dev.inventory_control.mapper.Mapper;
import com.jack_dev.inventory_control.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
	
	@Autowired
	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	//	Get All Address
	public ResponseEntity<List<AddressRequestDTO>> getAllAddress() {
		var addresses = Mapper.parseListObjects(
				addressRepository.findAll(), AddressRequestDTO.class
		);
		return ResponseEntity.status(HttpStatus.OK).body(addresses);
	}
	
	//	Get One Address
	public ResponseEntity<AddressRequestDTO> getOneAddress(UUID id) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, AddressRequestDTO.class));
	}
	
	//Create New Address
	public ResponseEntity<AddressRequestDTO> saveAddress(Address address) {
		var entity = Mapper.parseObject(addressRepository.save(address), AddressRequestDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
	// Update a Address
	public ResponseEntity<AddressRequestDTO> updateAddress(UUID id, Address address) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(addressRepository.save(address), AddressRequestDTO.class)
		);
	}
	
	public ResponseEntity<AddressRequestDTO> deleteAddress(UUID id) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		addressRepository.delete(entity);
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, AddressRequestDTO.class));
	}
}