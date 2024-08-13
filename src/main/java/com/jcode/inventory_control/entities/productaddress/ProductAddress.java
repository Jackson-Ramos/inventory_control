package com.jcode.inventory_control.entities.productaddress;

import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"product", "address"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_addresses")
public class ProductAddress {

    @EmbeddedId
    private ProductAddressId id;

    @ManyToOne()
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("addressId")
    @JoinColumn(name = "address_id")
    private Address address;

    private Long quantity;
}
