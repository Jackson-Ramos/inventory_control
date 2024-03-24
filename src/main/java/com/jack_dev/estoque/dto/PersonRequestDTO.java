package com.jack_dev.estoque.dto;

import java.util.Objects;
import java.util.UUID;

public class PersonRequestDTO {
	
	private UUID id;
	private Integer code;
	private String firtName;
	private String lastName;
	private String password;
	public PersonRequestDTO() {
	}
	
	public PersonRequestDTO(UUID id, Integer code, String firtName, String lastName, String password) {
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
		PersonRequestDTO person = (PersonRequestDTO) o;
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
