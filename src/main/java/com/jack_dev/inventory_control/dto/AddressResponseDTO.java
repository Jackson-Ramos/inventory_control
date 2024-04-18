package com.jack_dev.inventory_control.dto;

import com.jack_dev.inventory_control.entities.Product;
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
	private List<Product> products;
	
}
