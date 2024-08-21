package com.jcode.inventory_control.entities.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddressResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8938500391761870400L;

    private Long code;
    private Long stock;
    private Long deposit;
    private Long building;
    private Long road;
    private Long level;
    private Long apartment;

    @JsonIgnoreProperties({"address", "product"})
    private Set<ProductAddress> productAddresses;
}
