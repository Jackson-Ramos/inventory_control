package com.jcode.inventory_control.entities.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 2560776881501777379L;
	
	private Long code;
	private String name;
	private BigDecimal price;
	private List<String> addressIds;
	
}
