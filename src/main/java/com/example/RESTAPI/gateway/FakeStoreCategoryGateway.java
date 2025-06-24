package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
    @Override
    public CategoryDTO getAllCategories(){
        return null;
    }
}
