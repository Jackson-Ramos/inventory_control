package com.jcode.inventory_control.entities.barcode;

import com.jcode.inventory_control.entities.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(exclude = "product")
@Entity
@Table(name = "barcodes")
@NoArgsConstructor
@AllArgsConstructor
public class BarCode implements Serializable {

    @Serial
    private static final long serialVersionUID = -1631476879542755597L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barcode;
    private Long quantity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
