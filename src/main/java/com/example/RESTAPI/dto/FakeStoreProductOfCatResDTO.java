package com.example.RESTAPI.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductOfCatResDTO {
    private String status;
    private String message;
    private List<FakeStoreProductDTO> products;
}
