package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.address.AddressRequestDTO;
import com.jcode.inventory_control.repositories.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Set<Address>> findAll() {
        return ResponseEntity.ok(new HashSet<>(addressRepository.findAll()));
    }

    public ResponseEntity<Address> save(AddressRequestDTO data) {

        Address address = new Address();

        address.setStock(data.getStock());
        address.setDeposit(data.getDeposit());
        address.setBuilding(data.getBuilding());
        address.setRoad(data.getRoad());
        address.setLevel(data.getLevel());
        address.setApartment(data.getApartment());
        address.setProductAddresses(new HashSet<>());

        addressRepository.save(address);

        return ResponseEntity.ok(address);
    }
}
