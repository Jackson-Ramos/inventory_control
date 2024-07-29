package com.jcode.inventory_control.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcode.inventory_control.entities.address.Address;
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
public class ProductResponseDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -6195471281862871141L;
	
	private String id;
	private Long code;
	private String name;
	private BigDecimal price;
	@JsonIgnoreProperties("products")
	private List<Address> addresses;
	
}
