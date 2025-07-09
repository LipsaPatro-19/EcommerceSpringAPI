package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import com.example.RESTAPI.dto.FakeStoreProductOfCatResDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.gateway.api.FakeStoreCategoryApi;
import com.example.RESTAPI.mapper.GetAllCategoriesMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi){
        this.fakeStoreCategoryApi=_fakeStoreCategoryApi;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        //1. Make the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response= this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        //2. Check if the response is null and throw an IOException if it is
        if(response== null){
            throw new IOException("Failed to fetch categories from Fakestore API");
        }

        //3.Map the response to a list of CategoryDTO object
        return GetAllCategoriesMapper.toCategoryDTO(response);
    }

    @Override
    public List<ProductDTO> getAllProductOfCat(String type)  throws IOException {
        FakeStoreProductOfCatResDTO response= this.fakeStoreCategoryApi.getProductsOfCategory(type).execute().body();

        if(response==null){
            throw new IOException("Failed to fetch products of a category from Fakestore API");
        }

        return response.getProducts().stream()
                .map(product->ProductDTO.builder()
                        .brand(product.getBrand())
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .discount(product.getDiscount())
                        .build())
                .toList();
    }
}
