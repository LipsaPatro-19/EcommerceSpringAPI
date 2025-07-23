package com.example.RESTAPI.mapper;

import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.entity.Category;
import com.example.RESTAPI.entity.Product;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product){
        return ProductResponseDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.getPopular())
                .build();
    }

    public static Product toEntity(ProductResponseDTO dto, Category category){
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(category)
                .brand(dto.getBrand())
                .popular(dto.getPopular())
                .build();
    }
}
