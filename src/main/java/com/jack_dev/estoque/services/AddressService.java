package com.jack_dev.estoque.services;

import com.jack_dev.estoque.dto.AddressRequestDTO;
import com.jack_dev.estoque.entities.Address;
import com.jack_dev.estoque.mapper.Mapper;
import com.jack_dev.estoque.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
	
	@Autowired
	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	//	GetAll
	public ResponseEntity<List<AddressRequestDTO>> findAll() {
		var addresses = Mapper.parseListObjects(addressRepository.findAll(), AddressRequestDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(addresses);
	}
	
	//Post
	public ResponseEntity<AddressRequestDTO> save(Address address){
		var entity = Mapper.parseObject(addressRepository.save(address), AddressRequestDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}
}
