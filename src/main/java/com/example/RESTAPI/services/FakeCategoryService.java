package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.gateway.ICategoryGateway;
import java.io.IOException;
import java.util.List;

public class FakeCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;
    public FakeCategoryService(ICategoryGateway _categoryGateway){
        this.categoryGateway=_categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
}
