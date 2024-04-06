package com.jack_dev.inventory_control.services;

import com.jack_dev.inventory_control.controllers.AddressController;
import com.jack_dev.inventory_control.dto.AddressRequestDTO;
import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.entities.Address;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.exceptions.ResourceNotFound;
import com.jack_dev.inventory_control.mapper.Mapper;
import com.jack_dev.inventory_control.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private AddressController addressController;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	//Get All Product
	public ResponseEntity<List<ProductRequestDTO>> getAllProducts() {
		var products = Mapper.parseListObjects(productRepository.findAll(), ProductRequestDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	//	Get One Product
	public ResponseEntity<ProductRequestDTO> getOneProduct(UUID id) {
		var entity = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + " Not Found!")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, ProductRequestDTO.class)
		);
	}
	
	/*
		// Create Product
		public ResponseEntity<ProductRequestDTO> createNewProduct(Product product) {
			var entity = Mapper.parseObject(productRepository.save(product), ProductRequestDTO.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(entity);
		}
		*/
	
	// Create Product
	public ResponseEntity<ProductRequestDTO> createNewProduct(Product product) {
		Set<Address> addresses = (Set<Address>) addressService.getOneAddress(product.getId());
		
		Product prod = new Product(
				 null,
				product.getCode(),
				product.getName(),
				product.getPrice(),
				addresses
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(productRepository.save(prod), ProductRequestDTO.class)
		);
	}
	
	//Upgrade a Product
	public ResponseEntity<ProductRequestDTO> updateProduct(UUID id, Product product) {
		var entity = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + " Not Found!")
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(productRepository.save(product), ProductRequestDTO.class)
		);
	}
	
	// Delete One Product
	public ResponseEntity<ProductRequestDTO> deleteOneProduct(UUID id) {
		var entity = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + " Not Found!")
		);
		productRepository.delete(entity);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
				Mapper.parseObject(entity, ProductRequestDTO.class)
		);
	}
}
