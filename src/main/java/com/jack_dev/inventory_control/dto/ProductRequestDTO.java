package com.jack_dev.inventory_control.dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class ProductRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private Long code;
	private String name;
	private BigDecimal price;
	private Set<AddressRequestDTO> addresses;
	
	public ProductRequestDTO() {
	}
	
	public ProductRequestDTO(UUID id, Long code, String name, BigDecimal price, Set<AddressRequestDTO> addresses) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.addresses = addresses;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Set<AddressRequestDTO> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(Set<AddressRequestDTO> addresses) {
		this.addresses = addresses;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductRequestDTO product = (ProductRequestDTO) o;
		return Objects.equals(id, product.id)
				&& Objects.equals(code, product.code)
				&& Objects.equals(name, product.name)
				&& Objects.equals(price, product.price)
				&& Objects.equals(addresses, product.addresses);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, price, addresses);
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", code=" + code +
				", name='" + name + '\'' +
				", price=" + price +
				", addresses=" + addresses +
				'}';
	}
}
