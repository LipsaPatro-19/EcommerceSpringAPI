package com.example.RESTAPI.gateway;

import com.example.RESTAPI.dto.FakeStoreProductResDTO;
import com.example.RESTAPI.dto.ProductResponseDTO;
import com.example.RESTAPI.gateway.api.FakeStoreProductAPI;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductAPI fakeStoreProductAPI;

    public FakeStoreProductGateway(FakeStoreProductAPI _fakeStoreProductAPI){
        this.fakeStoreProductAPI=_fakeStoreProductAPI;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) throws Exception{
        FakeStoreProductResDTO result= this.fakeStoreProductAPI.getFakeProduct(id).execute().body();
        if(result==null){
            throw new Exception("Product not found");
        }

        return result.getProduct();
    }
}
