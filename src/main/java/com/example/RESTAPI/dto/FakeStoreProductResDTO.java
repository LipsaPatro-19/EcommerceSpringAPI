package com.example.RESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResDTO {
    private ProductResponseDTO product;
    private String message;
    private String status;
}
