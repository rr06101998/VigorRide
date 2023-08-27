package com.vigorride.product.data;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateProductPayload {

    private Long promotionId;
    private String name;
    private Long categoryId;
    private Long brandId;
    private String productDescription;
    private BigDecimal price;
    private List<String> imageLocations;
    private Long noOfItems;
}
