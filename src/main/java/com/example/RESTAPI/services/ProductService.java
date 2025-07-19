package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.entity.Product;
import com.example.RESTAPI.mapper.ProductMapper;
import com.example.RESTAPI.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("ProductService")
@Service
public class ProductService implements IProductService{
    private final ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo=repo;
    }

    public ProductResponseDTO getProductById(Long id) throws Exception{
//        return repo.findById(id)
//                .map(ProductMapper::toDTO)//this :: is only possible with .map otherwise we can use below implemetation as well
//                .orElseThrow(()-> new Exception("Product not found" ));

        Product product= repo.findById(id).orElseThrow(()-> new Exception("Product not found"));

        ProductResponseDTO dto= ProductMapper.toDTO(product);

        return dto;
    }
    public ProductResponseDTO createProduct(ProductResponseDTO dto){
        Product saved= repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDTO(saved);
    }
}
