package com.vigorride.entity;

import java.time.LocalDate;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@NotNull
	@Column(name="salutation",nullable=false)
	private String salutation;	
	
	@NotNull
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name",nullable=true)
	private String lastName;
	
	@NotNull
	@Column(name="email",nullable=false,unique = true)
	private String email;
	
	@NotNull
	@Column(name="password",nullable=false)
	private String password;
	
	
	@NotNull
	@Column(name="user_type",nullable=true)
	private Boolean userType;
	
	@NotNull
	@Column(name="user_name",nullable=true)
	private String userName;
	
	@NotNull
	@Column(name="dob",nullable=true)
	private Long dob;
	
	@Column(name="mobile_no",nullable=true,unique = true)
	private String mobile_no;
	
	@NotNull
	@Column(name="address_id",nullable=true)
	private String addressId;



}
