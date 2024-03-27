package com.jack_dev.estoque.services;

import com.jack_dev.estoque.dto.ProductRequestDTO;
import com.jack_dev.estoque.entities.Product;
import com.jack_dev.estoque.exceptions.ResourceNotFound;
import com.jack_dev.estoque.mapper.Mapper;
import com.jack_dev.estoque.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
	
	@Autowired
	private final ProductRepository productRepository;
	
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
		var entity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("The Id: " + "Not Found!"));
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, ProductRequestDTO.class));
	}
	
	// Create Product
	public ResponseEntity<ProductRequestDTO> CreateNewProduct(Product product){
		
	}
	
	
}
