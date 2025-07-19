package com.example.RESTAPI.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{
    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private String model;
    private String title;
    private String category;
    private String brand;
    private Boolean popular;
}
