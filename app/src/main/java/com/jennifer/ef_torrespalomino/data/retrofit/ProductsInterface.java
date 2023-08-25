package com.jennifer.ef_torrespalomino.data.retrofit;

import com.jennifer.ef_torrespalomino.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductsInterface {
    @GET("products")
    Call<List<Product>> getShowProduct();

    @GET("product/{productId}")
    Call<Product> getProductDetail(@Path("productId") int productId);
}