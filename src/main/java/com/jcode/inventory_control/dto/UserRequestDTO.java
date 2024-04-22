package com.jcode.inventory_control.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean accountCredentialsNonExpired;
	private Boolean enabled;
	
}
