package com.jcode.inventory_control.repositories;

import com.jcode.inventory_control.entities.product.Product;
import com.jcode.inventory_control.entities.product.ProductResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.jcode.inventory_control.entities.product.ProductResponseDTO(" +
            "p.code, p.name, p.description, p.price, p.imgUrl, p.category, p.barCodes, pa.address) " +
            "FROM Product p " +
            "LEFT JOIN p.productAddresses pa")
    Set<ProductResponseDTO> findAllWithAddresses();


}
