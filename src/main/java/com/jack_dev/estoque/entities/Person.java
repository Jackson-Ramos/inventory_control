package com.jack_dev.estoque.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "person_id")
	private UUID id;
	@Column(name = "code")
	private Integer code;
	@Column(name = "firt_name")
	private String firtName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "password")
	private String password;
	
	public Person() {
	}
	
	public Person(UUID id, Integer code, String firtName, String lastName, String password) {
		this.id = id;
		this.code = code;
		this.firtName = firtName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getFirtName() {
		return firtName;
	}
	
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id)
				&& Objects.equals(code, person.code)
				&& Objects.equals(firtName, person.firtName)
				&& Objects.equals(lastName, person.lastName)
				&& Objects.equals(password, person.password);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, code, firtName, lastName, password);
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", code=" + code +
				", firtName='" + firtName + '\'' +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
