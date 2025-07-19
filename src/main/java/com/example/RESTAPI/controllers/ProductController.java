package com.example.RESTAPI.controllers;

import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService _productService){
        this.productService=_productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) throws Exception{
        ProductResponseDTO result= this.productService.getProductById(id);

        return ResponseEntity.created(null).body(result);
    }

    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductResponseDTO dto){
        return ResponseEntity.ok(productService.create(dto));
    }
}
