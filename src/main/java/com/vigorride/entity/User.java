package com.vigorride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "salutation", nullable = false)
	private String salutation;

	@NotNull
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@NotNull
	@Column(name = "dob", nullable = true)
	private Long dob;

	@NotNull
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull
	@Column(name = "user_name", nullable = true)
	private String userName;

	@Column(name = "mobile_no", nullable = true, unique = true)
	private Long mobileNo;

	@NotNull
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "user_type", nullable = true)
	private Boolean userType;
}
