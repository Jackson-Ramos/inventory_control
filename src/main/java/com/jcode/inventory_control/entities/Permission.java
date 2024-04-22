package com.jcode.inventory_control.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tb_permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "permission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "permissions")
	private List<User> userList;
	
	@Override
	public String getAuthority() {
		return this.description;
	}
}
