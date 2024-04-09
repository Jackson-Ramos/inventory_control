package com.jack_dev.inventory_control.services;

import com.jack_dev.inventory_control.controllers.AddressController;
import com.jack_dev.inventory_control.dto.ProductRequestDTO;
import com.jack_dev.inventory_control.entities.Address;
import com.jack_dev.inventory_control.entities.Product;
import com.jack_dev.inventory_control.exceptions.ResourceNotFound;
import com.jack_dev.inventory_control.mapper.Mapper;
import com.jack_dev.inventory_control.repositories.AddressRepository;
import com.jack_dev.inventory_control.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final AddressController addressController;
	private final AddressRepository addressRepository;
	
	public ProductService(ProductRepository productRepository, AddressController addressController, AddressRepository addressRepository) {
		this.productRepository = productRepository;
		this.addressController = addressController;
		this.addressRepository = addressRepository;
	}
	
	//Get All Product
	public ResponseEntity<Set<ProductRequestDTO>> getAllProducts() {
		var products = Mapper.parseListObjects(productRepository.findAll(), ProductRequestDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	//	Get One Product
	public ResponseEntity<ProductRequestDTO> getOneProduct(String id) {
		var entity = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFound("The Id: " + id + " Not Found!")
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				Mapper.parseObject(entity, ProductRequestDTO.class)
		);
	}
	
	// Create Product
	public ResponseEntity<ProductRequestDTO> createNewProduct(Product product) {
		Set<Address> addresses = (Set<Address>) addressRepository.findById(product.getId());
		
		Product productResponse = new Product(
				"",
				product.getCode(),
				product.getName(),
				product.getPrice(),
				addresses
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Mapper.parseObject(productRepository.save(productResponse), ProductRequestDTO.class)
		);
	}
	
}
