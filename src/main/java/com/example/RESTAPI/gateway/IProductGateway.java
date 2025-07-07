package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.ProductResponseDTO;

public interface IProductGateway {
    public ProductResponseDTO getProductById(Long id) throws Exception;
}
