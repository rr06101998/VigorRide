package com.vigorride.product.entity;

import java.math.BigDecimal;

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
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="promotion_id")
	private Long promotionId;
	
	@NotNull
	@Column(name="name",nullable=false)
	private String name;
	
	@NotNull
	@Column(name="category_id",nullable=false)
	private Long categoryId;
	
	@Column(name="brand_id")
	private Long brandId;
	
	@NotNull
	@Column(name="product_description",nullable=false)
	private String productDescription;
	
	@NotNull
	@Column(name="price",nullable=false)
	private BigDecimal price;
	
}
