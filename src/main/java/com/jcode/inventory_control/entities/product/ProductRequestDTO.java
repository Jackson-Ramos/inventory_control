package com.jcode.inventory_control.entities.product;

import com.jcode.inventory_control.entities.barcode.BarCode;
import com.jcode.inventory_control.entities.productaddress.ProductAddress;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 2560776881501777379L;

	private @NotBlank String name;
	private @NotBlank String description;
	private @NotNull BigDecimal price;
	private String imgUrl;
	@Convert(converter = CategoryConverter.class)
	private @NotBlank Category category;
	private @NotNull Set<String> barCodes;
	private @NotBlank Set<String> productAddresses;
	
}
