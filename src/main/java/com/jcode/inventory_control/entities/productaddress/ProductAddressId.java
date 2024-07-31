package com.jcode.inventory_control.entities.productaddress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddressId {

    private Long productId;
    private Long addressId;

}
