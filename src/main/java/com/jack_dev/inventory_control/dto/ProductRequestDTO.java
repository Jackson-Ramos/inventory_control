package com.jack_dev.inventory_control.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
public class ProductRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Long code;
	private String name;
	private BigDecimal price;
	private Set<AddressRequestDTO> addresses;
	
}
