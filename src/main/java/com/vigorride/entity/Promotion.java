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
@Table(name="Promotion")
public class Promotion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@NotNull
	@Column(name="short_name",nullable=false)
	private String shortName;	
	
	@NotNull
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="valid_from",nullable=false)
	private LocalDate validFrom;
	
	@NotNull
	@Column(name="valid_before",nullable=false)
	private LocalDate validBefore;
	


}
