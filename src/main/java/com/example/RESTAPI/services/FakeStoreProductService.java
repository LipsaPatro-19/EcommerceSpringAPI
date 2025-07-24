package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.dto.ProductWithCategoryDTO;
import com.example.RESTAPI.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService{
    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway _productGateway){
        this.productGateway=_productGateway;
    }
    @Override
    public ProductResponseDTO getProductById(Long id){
        try{
            return this.productGateway.getProductById(id);
        }catch(Exception e){
            return null;
        }
    }

    public ProductResponseDTO createProduct(ProductResponseDTO dto){
        return null;
    }
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        return null;
    }
}
