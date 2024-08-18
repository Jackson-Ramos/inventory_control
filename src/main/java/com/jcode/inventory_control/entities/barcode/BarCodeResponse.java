package com.jcode.inventory_control.entities.barcode;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BarCodeResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6225703631903206620L;

    private Long id;
    private String barcode;
    private Long quantity;

}
