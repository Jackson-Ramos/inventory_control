package com.jcode.inventory_control.repositories;

import com.jcode.inventory_control.entities.barcode.BarCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarCodeRepository extends JpaRepository<BarCode, Long> {

}
