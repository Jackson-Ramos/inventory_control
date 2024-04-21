package com.jcode.inventory_control.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Long code;
	private Long amount;
	private Integer stock;
	private Integer deposit;
	private Integer read;
	private Integer building;
	private Integer level;
	private Integer apartment;
	@JsonIgnoreProperties("addresses")
	private List<Product> products;
	
}
