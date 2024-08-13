package com.jcode.inventory_control.entities.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class ProductRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2560776881501777379L;

    private @NotNull
    @Positive Long addressId;
    private @NotNull String name;
    private @NotNull String description;
    private @NotNull BigDecimal price;
    private @NotNull Long quantity;
    private String imgUrl;
    private @NotNull Category category;
    private String barCodes;
    private @Positive Long multipleBarcode;
    private @NotNull Set<String> productAddresses;


}
