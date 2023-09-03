package com.vigorride.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.product.data.CreateProductCategoryPayload;
import com.vigorride.product.data.CreateProductPayload;
import com.vigorride.product.entity.Inventory;
import com.vigorride.product.entity.Product;
import com.vigorride.product.entity.ProductCategory;
import com.vigorride.product.entity.ProductImages;
import com.vigorride.product.repository.InventoryRepositoryWrapper;
import com.vigorride.product.repository.ProductCategoryRepositoryWrapper;
import com.vigorride.product.repository.ProductImagesRepositoryWrapper;
import com.vigorride.product.repository.ProductRepositoryWrapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryWrapper productRepositoryWrapper;
    @Autowired
    private ProductCategoryRepositoryWrapper productCategoryRepositoryWrapper;
    @Autowired
    private ProductImagesRepositoryWrapper ProductImagesRepositoryWrapper;
    @Autowired
    private InventoryRepositoryWrapper InventoryRepositoryWrapper;

    @Override
    public String createProductCategory(CreateProductCategoryPayload createProductCategoryPayload) {
        ProductCategory category = this.productCategoryRepositoryWrapper
                .findByName(createProductCategoryPayload.getName());
        if (category != null) {
            return null;
        }
        ProductCategory productCategory = ProductCategory.builder()
                .categoryDescription(createProductCategoryPayload.getCategoryDescription())
                .name(createProductCategoryPayload.getName())
                .promotionId(createProductCategoryPayload.getPromotionId())
                .build();
        this.productCategoryRepositoryWrapper.save(productCategory);
        return "Category Added Successfully";

    }

    @Override
    public String createProduct(CreateProductPayload createProductPayload) {
        Optional<ProductCategory> category = this.productCategoryRepositoryWrapper
                .findById(createProductPayload.getCategoryId());
        if (!category.isPresent()) {
            // category not exist
            return null;
        }
        Product product = Product.builder()
                .brandId(createProductPayload.getBrandId())
                .categoryId(createProductPayload.getCategoryId())
                .name(createProductPayload.getName())
                .productDescription(createProductPayload.getProductDescription())
                .promotionId(createProductPayload.getPromotionId())
                .price(createProductPayload.getPrice())
                .build();
        Product productStored=this.productRepositoryWrapper.save(product);
        if(!createProductPayload.getImageLocations().isEmpty()){
            //add images
            List<ProductImages> productImages = createProductPayload.getImageLocations().stream()
                .map(imageUrl -> ProductImages.builder().productId(productStored.getId()).imageLocation(imageUrl).build())
                .collect(Collectors.toList());
            ProductImagesRepositoryWrapper.saveAll(productImages);
        }
        Inventory inventory=Inventory.builder()
                            .productId(productStored.getId())
                            .count(createProductPayload.getNoOfItems())
                            .build();
        this.InventoryRepositoryWrapper.save(inventory);

        return "Product Created Successfully.";

    }

}
