package com.jennifer.ef_torrespalomino.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.jennifer.ef_torrespalomino.model.ProductEntity;

import java.util.List;
@Dao
public interface ProductDao {
    @Insert
    public void addProduct(ProductEntity product);
    @Query("SELECT * FROM showProduct")
    public LiveData<List<ProductEntity>> getAll();
}
