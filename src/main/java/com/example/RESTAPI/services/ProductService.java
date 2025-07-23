package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.dto.ProductWithCategoryDTO;
import com.example.RESTAPI.entity.Category;
import com.example.RESTAPI.entity.Product;
import com.example.RESTAPI.mapper.ProductMapper;
import com.example.RESTAPI.repository.CategoryRepository;
import com.example.RESTAPI.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("ProductService")
@Service
public class ProductService implements IProductService{
    private final ProductRepository repo;
    private final CategoryRepository catrepo;

    public ProductService(ProductRepository repo, CategoryRepository catrepo){
        this.repo=repo;
        this.catrepo=catrepo;
    }

    public ProductResponseDTO getProductById(Long id) throws Exception{
//        return repo.findById(id)
//                .map(ProductMapper::toDTO)//this :: is only possible with .map otherwise we can use below implemetation as well
//                .orElseThrow(()-> new Exception("Product not found" ));

        Product product= repo.findById(id).orElseThrow(()-> new Exception("Product not found"));

        ProductResponseDTO dto= ProductMapper.toDTO(product);

        return dto;
    }
    public ProductResponseDTO createProduct(ProductResponseDTO dto) throws Exception{
        Category category= catrepo.findById(dto.getCategoryId()).orElseThrow(()-> new Exception("Category not found"));
        Product saved= repo.save(ProductMapper.toEntity(dto, category));
        return ProductMapper.toDTO(saved);
    }

    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        Product product=repo.findById(id).orElseThrow(()->new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
