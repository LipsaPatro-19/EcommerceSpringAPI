package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
    List<ProductDTO> getAllProductOfCat(String type)  throws IOException ;
}
