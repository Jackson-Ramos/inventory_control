package com.jack_dev.inventory_control.repositories;

import com.jack_dev.inventory_control.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
