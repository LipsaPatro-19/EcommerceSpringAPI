package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import com.example.RESTAPI.gateway.api.FakeStoreCategoryApi;
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
        FakeStoreCategoryResponseDTO response= this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if(response== null){
            throw new IOException("Failed to fetch categories from Fakestore API");
        }
        return response.getCategories().stream()
                .map(category->CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
