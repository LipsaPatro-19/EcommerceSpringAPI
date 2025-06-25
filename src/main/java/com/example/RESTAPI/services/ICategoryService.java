package com.example.RESTAPI.services;

import com.example.RESTAPI.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;


public interface ICategoryService {
    List<CategoryDTO>getAllCategories() throws IOException;
}
