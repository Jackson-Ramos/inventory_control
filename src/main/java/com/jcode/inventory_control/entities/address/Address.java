package com.jcode.inventory_control.entities.address;

import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"stock", "deposit", "building", "road", "level", "apartment"}) // TODO: NÃO FUNCIONA
})
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 2645380758571467850L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private Long stock;
    private Long deposit;
    private Long building;
    private Long road;
    private Long level;
    private Long apartment;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductAddress> productAddresses;

}
