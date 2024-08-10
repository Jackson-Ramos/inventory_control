package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.product.Category;
import com.jcode.inventory_control.entities.product.Product;
import com.jcode.inventory_control.entities.product.ProductRequestDTO;
import com.jcode.inventory_control.repositories.AddressRepository;
import com.jcode.inventory_control.repositories.BarCodeRepository;
import com.jcode.inventory_control.repositories.ProductAddressRepository;
import com.jcode.inventory_control.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<Product> saveProduct(ProductRequestDTO data) {

        Product product = new Product();
        product.setName(data.getName());
        product.setDescription(data.getDescription());
        product.setPrice(data.getPrice());
        product.setImgUrl(data.getImgUrl());
        product.setBlocked(false);
        product.setCategory(data.getCategory());

        return ResponseEntity.ok(productRepository.save(product));
    }
}
