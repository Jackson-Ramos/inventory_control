package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.barcode.BarCode;
import com.jcode.inventory_control.entities.product.Category;
import com.jcode.inventory_control.entities.product.Product;
import com.jcode.inventory_control.entities.product.ProductRequestDTO;
import com.jcode.inventory_control.repositories.AddressRepository;
import com.jcode.inventory_control.repositories.BarCodeRepository;
import com.jcode.inventory_control.repositories.ProductAddressRepository;
import com.jcode.inventory_control.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService {

    private final BarCodeRepository barCodeRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final ProductAddressRepository productAddressRepository;

    public ProductService(
            BarCodeRepository barCodeRepository,
            ProductRepository productRepository,
            AddressRepository addressRepository,
            ProductAddressRepository productAddressRepository) {
        this.barCodeRepository = barCodeRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.productAddressRepository = productAddressRepository;
    }

    @Transactional
    public ResponseEntity<Product> saveProduct(ProductRequestDTO data) {

        var address = addressRepository.findById(data.getAddressId());

        if (address.isPresent()) {

            Product product = new Product();

            product.setName(data.getName());
            product.setDescription(data.getDescription());
            product.setPrice(data.getPrice());
            product.setImgUrl(data.getImgUrl());
            product.setBlocked(false);
            product.setCategory(data.getCategory());
            product.setBarCodes(
                    data.getBarCodes() == null ?
                            generateBarCode(product) :
                            new HashSet<>(List.of(new BarCode(null, data.getBarCodes(), data.getMultipleBarcode(), product))));

            product.setProductAddresses(address.get().getProductAddresses());
            address.get().setProductAddresses(product.getProductAddresses());


            return ResponseEntity.ok(productRepository.save(product));
        }
        throw new IllegalArgumentException("Could not find address with id: " + data.getAddressId());
    }

    private Set<BarCode> generateBarCode(Product product) {

        Set<BarCode> barCodes = new HashSet<>();

        BarCode barCode = new BarCode();
        barCode.setProduct(product);
        barCode.setBarcode("7899970701566");
        barCode.setQuantity(1L);
        barCodes.add(barCode);
        return barCodes;
    }
}
