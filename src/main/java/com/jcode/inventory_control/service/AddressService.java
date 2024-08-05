package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.address.AddressRequestDTO;
import com.jcode.inventory_control.repositories.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
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

    @Transactional
    public ResponseEntity<Void> save(AddressRequestDTO data) {

        Optional<Address> existingAddress =
                addressRepository.findByDuplicateAddress(data.getStock(), data.getDeposit(), data.getBuilding(), data.getRoad(), data.getLevel(), data.getApartment());

        if (existingAddress.isPresent()) {
            throw new IllegalArgumentException("Address already exists");
        }

        Address address = new Address();

        address.setStock(data.getStock());
        address.setDeposit(data.getDeposit());
        address.setBuilding(data.getBuilding());
        address.setRoad(data.getRoad());
        address.setLevel(data.getLevel());
        address.setApartment(data.getApartment());
        address.setProductAddresses(new HashSet<>());

        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
