package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.entity.Category;
import com.example.RESTAPI.entity.Product;
import com.example.RESTAPI.mapper.GetAllCategoriesMapper;
import com.example.RESTAPI.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("CategoryService")
@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo){
        this.repo=repo;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<Category> categories= repo.findAll();
        if (categories.isEmpty()) {
            throw new RuntimeException("No categories found");
        }
        return categories.stream()
                .map(GetAllCategoriesMapper::toCategoryDTOO)
                .collect(Collectors.toList());
    }
//    public List<ProductDTO> getAllProductOfCat(Long id)  throws IOException {
//        Category category=repo.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
//        List<Product> product=category.getProducts();
//        return product.stream()
//                .map(pro -> ProductDTO.builder()
//                        .title(pro.getTitle())
//                        .price(pro.getPrice())
//                        .brand(pro.getBrand())
//                        .discount(pro.getDiscount())
//                        .build())
//                .toList();
//
//    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category created= repo.save(GetAllCategoriesMapper.toEntity(categoryDTO));
        return GetAllCategoriesMapper.toCategoryDTOO(created);
    }
}
