package com.vigorride.product.entity;

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
@Table(name="ProductImages")
public class ProductImages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@NotNull
	@Column(name="product_id",nullable=false)
	private Long productId;
	
	@NotNull
	@Column(name="image_loacation",nullable=false)
	private String imageLocation;
}
