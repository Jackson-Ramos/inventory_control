package com.jcode.inventory_control.entities.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.product.Product;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 2645380758571467850L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	private Integer stock;
	private Integer deposit;
	private Integer building;
	private Long road;
	private Integer level;
	private Integer apartment;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductAddress> productAddresses;
	
}