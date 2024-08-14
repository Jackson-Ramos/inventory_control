package com.jcode.inventory_control.service;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.barcode.BarCode;
import com.jcode.inventory_control.entities.product.Category;
import com.jcode.inventory_control.entities.product.Product;
import com.jcode.inventory_control.entities.product.ProductRequestDTO;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import com.jcode.inventory_control.entities.productaddress.ProductAddressId;
import com.jcode.inventory_control.repositories.AddressRepository;
import com.jcode.inventory_control.repositories.BarCodeRepository;
import com.jcode.inventory_control.repositories.ProductAddressRepository;
import com.jcode.inventory_control.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    public ProductService(
            ProductRepository productRepository,
            AddressRepository addressRepository) {
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public ResponseEntity<Void> saveProduct(ProductRequestDTO data) {

        var addressOptional = addressRepository.findById(data.getAddressId());

        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();

            Product product = new Product();

            product.setName(data.getName());
            product.setDescription(data.getDescription());
            product.setPrice(data.getPrice());
            product.setImgUrl(data.getImgUrl());
            product.setBlocked(false);
            product.setCategory(data.getCategory());

            Set<BarCode> barCodes = data.getBarCodes() == null ?
                    generateBarCode(product) :
                    new HashSet<>(List.of(new BarCode(null, data.getBarCodes(), data.getMultipleBarcode(), product)));

            product.setBarCodes(barCodes);

            Set<ProductAddress> productAddresses = new HashSet<>();

            ProductAddress productAddress = new ProductAddress(
                    new ProductAddressId( product.getCode(), address.getCode()),
                    product,
                    address,
                    data.getQuantity()
            );
            productAddresses.add(productAddress);

            product.setProductAddresses(productAddresses);
            productAddresses.forEach(pa -> pa.getAddress().getProductAddresses().add(pa));

            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
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
