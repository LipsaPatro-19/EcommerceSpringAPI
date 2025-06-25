package com.example.RESTAPI.gateway.api;

import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreCategoryApi {
    @GET("products/category")
    //Each Call represents a single http request and response pair
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories();
}
