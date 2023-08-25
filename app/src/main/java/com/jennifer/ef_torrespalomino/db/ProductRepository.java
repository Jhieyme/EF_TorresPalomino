package com.jennifer.ef_torrespalomino.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jennifer.ef_torrespalomino.model.ProductEntity;

import java.util.List;

public class ProductRepository {

    private ProductDao dao;
    private StoreDatabase db;

    public ProductRepository(Application application) {
        db = StoreDatabase.getInstance(application);
        dao = db.productDao();
    }
    public void addProduct(ProductEntity productEntity){
        StoreDatabase.dataBaseWriteExecutor.execute(() ->
                dao.addProduct(productEntity));
    }

    public LiveData<List<ProductEntity>> getAll(){
        return dao.getAll();
    }
}
