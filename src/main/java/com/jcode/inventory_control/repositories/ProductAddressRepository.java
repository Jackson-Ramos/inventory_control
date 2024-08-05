package com.jcode.inventory_control.repositories;

import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAddressRepository extends JpaRepository<ProductAddress, Long> {
}
