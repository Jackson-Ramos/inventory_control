package com.jack_dev.inventory_control.repositories;

import com.jack_dev.inventory_control.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
