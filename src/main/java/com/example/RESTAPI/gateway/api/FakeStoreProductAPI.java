package com.example.RESTAPI.gateway.api;

import com.example.RESTAPI.dto.FakeStoreProductResDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductAPI {
    @GET("products/{id}")
    Call<FakeStoreProductResDTO> getFakeProduct(@Path("id") Long id) throws Exception;
}
