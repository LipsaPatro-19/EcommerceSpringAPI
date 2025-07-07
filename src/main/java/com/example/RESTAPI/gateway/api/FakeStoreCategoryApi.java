package com.example.RESTAPI.gateway.api;

import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import com.example.RESTAPI.dto.FakeStoreProductOfCatResDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FakeStoreCategoryApi {
    @GET("products/category") //Get all categories
    //Each Call represents a single http request and response pair
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories();

    @GET("products/category")
    Call<FakeStoreProductOfCatResDTO> getProductsOfCategory(@Query("type") String type);
}
