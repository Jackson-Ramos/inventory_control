package com.jcode.inventory_control.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.address.Address;
import com.jcode.inventory_control.entities.barcode.BarCode;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity()
@Table(name = "tb_products")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -3180591242116609220L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BarCode> barCodes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_addresses",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    @JsonIgnoreProperties("products")
    private Set<Address> addresses;

}
