package com.jack_dev.inventory_control.services;

import com.jack_dev.inventory_control.dto.AddressRequestDTO;
import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.entities.Address;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.exceptions.ResourceNotFound;
import com.jack_dev.inventory_control.mapper.Mapper;
import com.jack_dev.inventory_control.repositories.AddressRepository;
import com.jack_dev.inventory_control.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {
	
	private final AddressRepository addressRepository;
	private final ProductRepository productRepository;
	
	public AddressService(AddressRepository addressRepository, ProductRepository productRepository) {
		this.addressRepository = addressRepository;
		this.productRepository = productRepository;
	}
	
	//	Get All Address
	public ResponseEntity<List<Address>> getAllAddress() {
		return ResponseEntity.status(HttpStatus.OK).body(addressRepository.findAll());
	}
	
	//	Get One Address
	public ResponseEntity<Address> getOneAddress(String id) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	// Post new Address
	public ResponseEntity<AddressRequestDTO> saveAddress(AddressRequestDTO addressRequestDTO) {
		List<Product> productsList =  productRepository.findAllById(addressRequestDTO.getProductIds());
		
		
		Address addressResponse = new Address(
				null,
				addressRequestDTO.getCode(),
				addressRequestDTO.getAmount(),
				addressRequestDTO.getStock(),
				addressRequestDTO.getDeposit(),
				addressRequestDTO.getRead(),
				addressRequestDTO.getBuilding(),
				addressRequestDTO.getLevel(),
				addressRequestDTO.getApartment(),
				productsList
		);
		productsList.forEach(addresses -> {
			addresses.addAddress(addressResponse);
		});
		var entity = Mapper.parseObject(addressRepository.save(addressResponse), AddressRequestDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
}