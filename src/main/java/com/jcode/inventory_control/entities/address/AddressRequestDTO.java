package com.jcode.inventory_control.entities.address;

import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 4150272185461983514L;

	private Long stock;
	private Long deposit;
	private Long building;
	private Long road;
	private Long level;
	private Long apartment;
	private Set<ProductAddress> productAddresses;
}
