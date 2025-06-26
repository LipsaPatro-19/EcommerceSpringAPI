package com.example.RESTAPI.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String title;
    private Integer price;
    private String brand;
    private Integer discount;
}
