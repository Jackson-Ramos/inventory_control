package com.jack_dev.inventory_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_products")
public class Product implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "product_id")
	private String id;
	
	@Column(name = "product_code", unique = true, nullable = false)
	private Long code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "products_addresses",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "adress_id")
	)
	@JsonIgnoreProperties("Product")
	private Set<Address> addresses;
	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
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
