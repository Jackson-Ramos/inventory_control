package com.jcode.inventory_control.entities.address;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddressResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8938500391761870400L;

    private String id;
    private Long code;
    private Long amount;
    private Integer stock;
    private Integer deposit;
    private Integer read;
    private Integer building;
    private Integer level;
    private Integer apartment;

}
