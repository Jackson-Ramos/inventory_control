package com.jack_dev.inventory_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_Address")
public class Address implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "adress_id")
	private UUID id;
	
	@Column(name = "address_code", unique = true, nullable = false)
	private Long code;
	@Column(name = "amount")
	private Long amount;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "deposit")
	private Integer deposit;
	@Column(name = "read")
	private Integer read;
	@Column(name = "building")
	private Integer building;
	@Column(name = "level")
	private Integer level;
	@Column(name = "apartment")
	private Integer apartment;
	@ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("address")
	private Set<Product> products;
	
	public Address() {
	}
	
	public Address(UUID id, Long code, Long amount, Integer stock, Integer deposit, Integer read,
	               Integer building, Integer level, Integer apartment, Set<Product> products) {
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
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
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
