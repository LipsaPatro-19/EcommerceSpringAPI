package com.example.RESTAPI.services;

import com.example.RESTAPI.gateway.ICategoryGateway;

import java.util.List;

public class FakeCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;
    public FakeCategoryService(ICategoryGateway _categoryGateway){
        this.categoryGateway=_categoryGateway;
    }
    @Override
    public List<String> getAllCategories(){
        return List.of();
    }
}
