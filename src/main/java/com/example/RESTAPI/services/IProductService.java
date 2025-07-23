package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.ProductResponseDTO;

public interface IProductService {
    ProductResponseDTO getProductById(Long id) throws Exception;

    ProductResponseDTO createProduct(ProductResponseDTO dto) throws Exception;
}
