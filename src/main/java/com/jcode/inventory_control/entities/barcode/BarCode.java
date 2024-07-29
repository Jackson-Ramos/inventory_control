package com.jcode.inventory_control.entities.barcode;

import com.jcode.inventory_control.entities.product.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "bar_code")
public class BarCode implements Serializable {

    @Serial
    private static final long serialVersionUID = -1631476879542755597L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
