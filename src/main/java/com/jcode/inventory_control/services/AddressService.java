package com.jcode.inventory_control.services;

import com.jcode.inventory_control.dto.AddressRequestDTO;
import com.jcode.inventory_control.dto.AddressResponseDTO;
import com.jcode.inventory_control.entities.Address;
import com.jcode.inventory_control.entities.Product;
import com.jcode.inventory_control.exceptions.ResourceNotFound;
import com.jcode.inventory_control.mapper.Mapper;
import com.jcode.inventory_control.repositories.AddressRepository;
import com.jcode.inventory_control.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {
	
	private final AddressRepository addressRepository;
	private final ProductRepository productRepository;
	
	public AddressService(
			AddressRepository addressRepository,
			ProductRepository productRepository
	) {
		this.addressRepository = addressRepository;
		this.productRepository = productRepository;
	}
	
	//	Get All Address
	public ResponseEntity<List<AddressResponseDTO>> getAllAddress() {
		return ResponseEntity.status(HttpStatus.OK).
				body(Mapper.parseListObjects(addressRepository.findAll(), AddressResponseDTO.class));
	}
	
	//	Get One Address
	public ResponseEntity<AddressResponseDTO> getOneAddress(String id) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, AddressResponseDTO.class));
	}

	// Post new Address
	public ResponseEntity<AddressResponseDTO> saveAddress(AddressRequestDTO addressRequestDTO) {
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
		
		var entity = Mapper.parseObject(addressRepository.save(addressResponse), AddressResponseDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
}