package com.example.RESTAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Locale;

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
    private String brand;
    private Boolean popular;

    //Each product belongs to one category
    //and one category can have many products
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
