package com.jack_dev.inventory_control.services;

import com.jack_dev.inventory_control.controllers.AddressController;
import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.dto.ProductResponseDTO;
import com.jack_dev.inventory_control.entities.Address;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.exceptions.ResourceNotFound;
import com.jack_dev.inventory_control.mapper.Mapper;
import com.jack_dev.inventory_control.repositories.AddressRepository;
import com.jack_dev.inventory_control.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final AddressRepository addressRepository;
	
	public ProductService(
			ProductRepository productRepository,
			AddressRepository addressRepository
	) {
		this.productRepository = productRepository;
		this.addressRepository = addressRepository;
	}
	
	//Get All Product
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		var entities = Mapper.parseListObjects(productRepository.findAll(), ProductResponseDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(entities);
	}
	
	//	Get One Product
	public ResponseEntity<ProductResponseDTO> getOneProduct(String id) {
		var entity = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + " Not Found!")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, ProductResponseDTO.class)
		);
	}
	// Create Product
	public ResponseEntity<ProductResponseDTO> createNewProduct(ProductRequestDTO productRequestDTO) {
		
		List<Address> addresses = addressRepository.findAllById(productRequestDTO.getAddressIds());
		
		Product productResponse = new Product(
				null,
				productRequestDTO.getCode(),
				productRequestDTO.getName(),
				productRequestDTO.getPrice(),
				addresses
		);
		
		addresses.forEach(address -> {
			address.addProduct(productResponse);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(productRepository.save(productResponse), ProductResponseDTO.class)
		);
	}
}
