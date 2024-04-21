package com.jcode.inventory_control.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String name;
	private BigDecimal price;
	private List<String> addressIds;
	
}
