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

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class AddressService {
	
	private final AddressRepository addressRepository;
	private final ProductRepository productRepository;
	
	public AddressService(AddressRepository addressRepository, ProductRepository productRepository) {
		this.addressRepository = addressRepository;
		this.productRepository = productRepository;
	}
	
	//	Get All Address
	public ResponseEntity<List<AddressRequestDTO>> getAllAddress() {
		var addresses = Mapper.parseListObjects(
				addressRepository.findAll(), AddressRequestDTO.class
		);
		return ResponseEntity.status(HttpStatus.OK).body((List<AddressRequestDTO>) addresses);
	}
	
	//	Get One Address
	public ResponseEntity<AddressRequestDTO> getOneAddress(String id) {
		var entity = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + "Not Found")
		);
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, AddressRequestDTO.class));
	}

	// Post new Address
	public ResponseEntity<AddressRequestDTO> saveAddress(Address address) {
		Set<Product> productsList = productRepository.findById(address.getId());
		Address addressResponse = new Address(
				address.getId(),
				address.getCode(),
				address.getAmount(),
				address.getStock(),
				address.getDeposit(),
				address.getRead(),
				address.getBuilding(),
				address.getLevel(),
				address.getApartment(),
				productsList
		);
		var entity = Mapper.parseObject(addressRepository.save(addressResponse), AddressRequestDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
	
}