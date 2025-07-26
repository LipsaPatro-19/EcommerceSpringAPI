package com.example.RESTAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    //One category has many products
    //, fetch = FetchType.LAZY, cascade = CascadeType.ALL
    //mappedBy means bidirectional relationship
    //This doesn't mean that you are trying to store a list of products inside category table
    //Telling JpA, the relationship is already owned by the product entity. So, just read from there.
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY) //this category is a field in Product entity which is mapped here in Category entity
    private List<Product> products;
}
