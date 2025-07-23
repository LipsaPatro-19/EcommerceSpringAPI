package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;

import java.io.IOException;
import java.util.List;


public interface ICategoryService {
    List<CategoryDTO>getAllCategories() throws IOException;
//    List<ProductDTO>getAllProductOfCat(Long id)  throws IOException ;
}
