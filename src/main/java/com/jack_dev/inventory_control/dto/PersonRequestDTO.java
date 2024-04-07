package com.jack_dev.inventory_control.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDTO {
	
	private String id;
	private Integer code;
	private String firtName;
	private String lastName;
	private String password;
	
}
