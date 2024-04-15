package com.jack_dev.inventory_control.dto;

import com.jack_dev.inventory_control.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Long code;
	private String name;
	private BigDecimal price;
	private List<String> addressIds;
	
}
