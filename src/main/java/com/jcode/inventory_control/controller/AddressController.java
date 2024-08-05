package com.jcode.inventory_control.controller;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.address.AddressRequestDTO;
import com.jcode.inventory_control.service.AddressService;
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
    public ResponseEntity<Address> saveAddress(@RequestBody AddressRequestDTO data) {
        return addressService.save(data);
    }

    @GetMapping
    public ResponseEntity<Set<Address>> getAllAddresses() {
        return addressService.findAll();
    }
}
