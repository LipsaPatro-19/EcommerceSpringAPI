package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.entity.Category;
import com.example.RESTAPI.gateway.ICategoryGateway;
import com.example.RESTAPI.mapper.GetAllCategoriesMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;
    public FakeCategoryService(@Qualifier("fakeStoreTemplateGateway") ICategoryGateway _categoryGateway){
        this.categoryGateway=_categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
//    public List<ProductDTO> getAllProductOfCat(String category)  throws IOException {
//        return this.categoryGateway.getAllProductOfCat(category);
//    }
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        return null;
    }
}
