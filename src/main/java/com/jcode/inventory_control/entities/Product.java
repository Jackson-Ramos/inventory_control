package com.jcode.inventory_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity()
@Table(name = "tb_products")
public class Product implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "product_id", unique = true, nullable = false)
	private String id;
	
	@Column(name = "product_code", unique = true, nullable = false)
	private Long code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "products_addresses",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "adress_id")
	)
	@JsonIgnoreProperties("products")
	private List<Address> addresses;
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}
	
}
