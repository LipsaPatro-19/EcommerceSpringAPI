package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import com.example.RESTAPI.dto.ProductDTO;
import com.example.RESTAPI.mapper.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreTemplateGateway")
//@Primary
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder _restTemplateBuilder){
        this.restTemplateBuilder=_restTemplateBuilder;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate= restTemplateBuilder.build();

        String url="https://fakestoreapi.in/api/products/category";
        ResponseEntity<FakeStoreCategoryResponseDTO> response=restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);
        if(response.getBody()==null){
            throw new IOException("Failed to fetch categories");
        }

        return GetAllCategoriesMapper.toCategoryDTO(response.getBody());
    }

    @Override
    public List<ProductDTO> getAllProductOfCat(String type) throws IOException{
        return List.of();
    }
}
