package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.dto.ProductWithCategoryDTO;

public interface IProductService {
    ProductResponseDTO getProductById(Long id) throws Exception;

    ProductResponseDTO createProduct(ProductResponseDTO dto) throws Exception;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
