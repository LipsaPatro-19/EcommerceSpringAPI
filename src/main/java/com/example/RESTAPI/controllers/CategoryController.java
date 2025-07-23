package com.example.RESTAPI.controllers;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
     private final ICategoryService categoryService;

     CategoryController(@Qualifier("CategoryService") ICategoryService _categoryService){
         this.categoryService=_categoryService;
     }

     @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception{
         if(name!=null && !name.isBlank()){
             CategoryDTO dto=this.categoryService.getByName(name);
             return ResponseEntity.ok(dto);
         }else{
             List<CategoryDTO> result= this.categoryService.getAllCategories();

             //returns with specific status code, we can modify the status codes with the help of ResponseEntity which is from
             //Spring framework
             return ResponseEntity.ok(result);
         }

     }

//     @GetMapping("/products")
//     public List<ProductDTO> getAllProductsOfCat(@RequestParam(defaultValue ="mobile") String category)  throws IOException {
//         return this.categoryService.getAllProductOfCat(category);
//     }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException{
        CategoryDTO created=this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }
}


//controller-->Service-->Gateway