package com.jcode.inventory_control.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequestDTO implements Serializable {
	
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
	private List<String> productIds;
	
}
