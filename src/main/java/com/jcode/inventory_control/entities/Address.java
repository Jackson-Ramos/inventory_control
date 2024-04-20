package com.jcode.inventory_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_Address")
public class Address implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "adress_id")
	private String id;
	
	@Column(name = "address_code", unique = true, nullable = false)
	private Long code;
	
	@Column(name = "amount", nullable = false)
	private Long amount;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "deposit", nullable = false)
	private Integer deposit;
	
	@Column(name = "read", nullable = false)
	private Integer read;
	
	@Column(name = "building", nullable = false)
	private Integer building;
	
	@Column(name = "level", nullable = false)
	private Integer level;
	
	@Column(name = "apartment", nullable = false)
	private Integer apartment;
	
	@ManyToMany(mappedBy = "addresses")
	@JsonIgnoreProperties("addresses")
	private List<Product> products;
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
}
