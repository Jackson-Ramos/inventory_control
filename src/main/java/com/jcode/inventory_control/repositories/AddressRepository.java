package com.jcode.inventory_control.repositories;

import com.jcode.inventory_control.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.stock =:stock AND a.deposit =:deposit AND a.building =:building AND a.road =:road AND a.level = :level AND a.apartment = :apartment")
    Optional<Address> findByDuplicateAddress(
            @Param("stock") Long stock,
            @Param("deposit") Long deposit,
            @Param("building") Long building,
            @Param("road") Long road,
            @Param("level") Long level,
            @Param("apartment") Long apartment
    );

    @Query("SELECT a.code, a.stock, a.deposit, a.building, a.road, a.level, a.apartment, p.product FROM Address a JOIN a.productAddresses p")
    Set<Address> findAllAddressesWithProducts();
}

