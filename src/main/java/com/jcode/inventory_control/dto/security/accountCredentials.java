package com.jcode.inventory_control.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class accountCredentials implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
}
