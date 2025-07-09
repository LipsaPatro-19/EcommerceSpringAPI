package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
//import com.example.RESTAPI.services.ICategoryService;
import com.example.RESTAPI.dto.ProductDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreTemplateGateway")
//@Primary
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }

    @Override
    public List<ProductDTO> getAllProductOfCat(String type) throws IOException{
        return List.of();
    }
}
