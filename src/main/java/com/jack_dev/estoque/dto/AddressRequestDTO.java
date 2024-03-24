package com.jack_dev.estoque.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class AddressRequestDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private Long code;
	private Long amount;
	private Integer stock;
	private Integer deposit;
	private Integer read;
	private Integer building;
	private Integer level;
	private Integer apartment;
	private Set<ProductRequestDTO> products;
	
	public AddressRequestDTO() {
	}
	
	public AddressRequestDTO(UUID id, Long code, Long amount, Integer stock, Integer deposit, Integer read,
	                         Integer building, Integer level, Integer apartment, Set<ProductRequestDTO> products) {
		this.id = id;
		this.code = code;
		this.amount = amount;
		this.stock = stock;
		this.deposit = deposit;
		this.read = read;
		this.building = building;
		this.level = level;
		this.apartment = apartment;
		this.products = products;
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
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Integer getDeposit() {
		return deposit;
	}
	
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	
	public Integer getRead() {
		return read;
	}
	
	public void setRead(Integer read) {
		this.read = read;
	}
	
	public Integer getBuilding() {
		return building;
	}
	
	public void setBuilding(Integer building) {
		this.building = building;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getApartment() {
		return apartment;
	}
	
	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}
	
	public Set<ProductRequestDTO> getProducts() {
		return products;
	}
	
	public void setProducts(Set<ProductRequestDTO> products) {
		this.products = products;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddressRequestDTO address = (AddressRequestDTO) o;
		return Objects.equals(id, address.id)
				&& Objects.equals(code, address.code)
				&& Objects.equals(amount, address.amount)
				&& Objects.equals(stock, address.stock)
				&& Objects.equals(deposit, address.deposit)
				&& Objects.equals(read, address.read)
				&& Objects.equals(building, address.building)
				&& Objects.equals(level, address.level)
				&& Objects.equals(apartment, address.apartment)
				&& Objects.equals(products, address.products);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, code, amount, stock, deposit, read, building, level, apartment, products);
	}
	
	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", code=" + code +
				", amount=" + amount +
				", stock=" + stock +
				", deposit=" + deposit +
				", read=" + read +
				", building=" + building +
				", level=" + level +
				", apartment=" + apartment +
				", products=" + products +
				'}';
	}
}
