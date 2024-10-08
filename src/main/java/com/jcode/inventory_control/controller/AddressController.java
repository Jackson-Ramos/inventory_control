package com.jcode.inventory_control.controller;

import com.jcode.inventory_control.entities.address.AddressRequestDTO;
import com.jcode.inventory_control.entities.address.AddressResponseDTO;
import com.jcode.inventory_control.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> saveAddress(@RequestBody @Valid AddressRequestDTO data) {
        return addressService.save(data);
    }

    @GetMapping
    public ResponseEntity<Set<AddressResponseDTO>> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable Long code) {
        return addressService.findById(code);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long code) {
        return addressService.deleteById(code);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Void> updateAddress(@PathVariable Long code, @RequestBody @Valid AddressRequestDTO data) {
        return addressService.update(code, data);
    }
}
