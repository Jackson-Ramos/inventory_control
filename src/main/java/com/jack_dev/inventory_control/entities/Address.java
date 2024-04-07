package com.jack_dev.inventory_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

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
	@Column(name = "amount")
	private Long amount;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "deposit")
	private Integer deposit;
	@Column(name = "read")
	private Integer read;
	@Column(name = "building")
	private Integer building;
	@Column(name = "level")
	private Integer level;
	@Column(name = "apartment")
	private Integer apartment;
	@ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("address")
	private Set<Product> products;
	
}
