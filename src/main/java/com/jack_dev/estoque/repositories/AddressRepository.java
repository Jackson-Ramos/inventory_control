package com.jack_dev.estoque.repositories;

import com.jack_dev.estoque.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
