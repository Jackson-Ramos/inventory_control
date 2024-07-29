package com.jcode.inventory_control.entities.user;


import lombok.Getter;

@Getter
public enum Permission {

	ADMIN("admin"),
	MANAGER("manager"),
	USER("user");

	private final String permission;

	Permission(String permission) {
		this.permission = permission;
	}

}
