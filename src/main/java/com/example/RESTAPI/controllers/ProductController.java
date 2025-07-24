package com.example.RESTAPI.controllers;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.dto.ProductWithCategoryDTO;
import com.example.RESTAPI.exception.ProductNotFoundException;
import com.example.RESTAPI.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(@Qualifier("ProductService") IProductService _productService){
        this.productService=_productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        ProductResponseDTO result= this.productService.getProductById(id);

        return ResponseEntity.created(null).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductResponseDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable long id) throws Exception{
        ProductWithCategoryDTO dto= productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
