package com.jack_dev.inventory_control.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Integer code;
	private String firtName;
	private String lastName;
}
