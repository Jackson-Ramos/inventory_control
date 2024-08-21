package com.jcode.inventory_control.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.barcode.BarCodeResponse;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6195471281862871141L;

    private Long code;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;

    @Convert(converter = CategoryConverter.class)
    private Category category;

    private Set<BarCodeResponse> barCodes;

    @JsonIgnoreProperties({"product", "address"})
    private Set<ProductAddress> productAddresses;

}
