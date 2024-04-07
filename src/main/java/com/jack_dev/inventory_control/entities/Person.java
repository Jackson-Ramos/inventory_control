package com.jack_dev.inventory_control.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_person")
public class Person extends RepresentationModel<Person> implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "person_id")
	private String id;
	@Column(name = "code")
	private Integer code;
	@Column(name = "firt_name")
	private String firtName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "password")
	private String password;
}
