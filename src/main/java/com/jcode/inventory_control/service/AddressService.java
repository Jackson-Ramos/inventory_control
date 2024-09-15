package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.address.AddressRequestDTO;
import com.jcode.inventory_control.entities.address.AddressResponseDTO;
import com.jcode.inventory_control.mapper.Mapper;
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

    public ResponseEntity<Set<AddressResponseDTO>> findAll() {
        var addresses = Mapper.parseListObjects(new HashSet<>(addressRepository.findAll()), AddressResponseDTO.class);
        return ResponseEntity.ok(addresses);
    }

    public ResponseEntity<AddressResponseDTO> findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(Mapper.parseObject(address.get(), AddressResponseDTO.class));
        }
        throw new IllegalArgumentException("The address does not exist");
    }

    @Transactional
    public ResponseEntity<Void> save(AddressRequestDTO data) {

        Optional<Address> existingAddress = addressRepository.findByDuplicateAddress(
                data.getStock(),
                data.getDeposit(),
                data.getBuilding(),
                data.getRoad(),
                data.getLevel(),
                data.getApartment()
        );

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

    public ResponseEntity<Void> deleteById(Long id) {

        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.noContent().build();
        }
        throw new IllegalArgumentException("Address does not exist");
    }

    @Transactional
    public ResponseEntity<Void> update(Long code, AddressRequestDTO data) {

        Optional<Address> existingAddress =
                addressRepository.findByDuplicateAddress(data.getStock(), data.getDeposit(), data.getBuilding(), data.getRoad(), data.getLevel(), data.getApartment());

        if (existingAddress.isPresent()) throw new IllegalArgumentException("Address already exists");

        Optional<Address> address = addressRepository.findById(code);

        if (address.isPresent()) {

            address.get().setStock(data.getStock() != null ? data.getStock() : address.get().getStock());
            address.get().setDeposit(data.getDeposit() != null ? data.getDeposit() : address.get().getDeposit());
            address.get().setBuilding(data.getBuilding() != null ? data.getBuilding() : address.get().getBuilding());
            address.get().setRoad(data.getRoad() != null ? data.getRoad() : address.get().getRoad());
            address.get().setLevel(data.getLevel() != null ? data.getLevel() : address.get().getLevel());
            address.get().setApartment(data.getApartment() != null ? data.getApartment() : address.get().getApartment());

            addressRepository.save(address.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
