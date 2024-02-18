package com.vigorride.sequence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sequence_config")
public class SequenceConfig{


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;

	@Column(name = "sequence_type", nullable = false)
	private String sequenceType;

	@Column(name = "config")
	private String config;
}
