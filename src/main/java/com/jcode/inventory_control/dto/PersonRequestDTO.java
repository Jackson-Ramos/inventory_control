package com.jcode.inventory_control.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String firtName;
	private String lastName;
	private String password;
	
}
