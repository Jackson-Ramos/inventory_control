package com.jcode.inventory_control.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private Long amount;
	private Integer stock;
	private Integer deposit;
	private Integer read;
	private Integer building;
	private Integer level;
	private Integer apartment;
	private List<String> productIds;
	
}
