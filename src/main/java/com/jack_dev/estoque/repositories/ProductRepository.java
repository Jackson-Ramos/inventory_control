package com.jack_dev.estoque.repositories;

import com.jack_dev.estoque.entities.Address;
import com.jack_dev.estoque.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
