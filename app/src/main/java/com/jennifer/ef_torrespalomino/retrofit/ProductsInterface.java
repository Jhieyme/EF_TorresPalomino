package com.jennifer.ef_torrespalomino.retrofit;


import com.jennifer.ef_torrespalomino.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsInterface {
    @GET("products")
    Call<List<Product>> getShowProduct();
}