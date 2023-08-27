package com.vigorride.product.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateProductCategoryPayload {
	private Long promotionId;
	private String name;
	private String categoryDescription;
}
