package com.jcode.inventory_control.entities.product;

import com.jcode.inventory_control.entities.barcode.BarCode;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
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
@Table(name = "products")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -3180591242116609220L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
    private Boolean blocked;

   @Convert(converter = CategoryConverter.class)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BarCode> barCodes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductAddress> productAddresses;

}
