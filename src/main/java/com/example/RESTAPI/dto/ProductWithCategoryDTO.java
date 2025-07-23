package com.example.RESTAPI.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDTO {
    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private String model;
    private Long id;
    private String title;
    private String brand;
    private Boolean popular;
    private CategoryDTO category;
}
