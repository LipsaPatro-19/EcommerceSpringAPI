package com.example.RESTAPI.controllers;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
     private final ICategoryService categoryService;

     CategoryController(ICategoryService _categoryService){
         this.categoryService=_categoryService;
     }

     @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException{
         return this.categoryService.getAllCategories();
     }

     @GetMapping("/products")
     public List<ProductDTO> getAllProductsOfCat(@RequestParam(defaultValue ="mobile") String category)  throws IOException {
         return this.categoryService.getAllProductOfCat(category);
     }
}


//controller-->Service-->Gateway