package com.jennifer.ef_torrespalomino.fragments;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.jennifer.ef_torrespalomino.db.ProductRepository;
import com.jennifer.ef_torrespalomino.model.Product;
import com.jennifer.ef_torrespalomino.model.ProductEntity;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private ProductRepository repository;
    public LiveData<List<ProductEntity>> listLiveData = new MutableLiveData<List<ProductEntity>>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
    }

    public void addProduct(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(product.getTitle());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(Double.parseDouble(String.valueOf(product.getPrice())));
        productEntity.setCategory(product.getCategory());
        productEntity.setImage(product.getImage());
        repository.addProduct(productEntity);
    }

    public void getProducts(){
        listLiveData = repository.getAll();
    }

    public class HomeViewModelFactory implements ViewModelProvider.Factory{
        private final Application application;
        public HomeViewModelFactory(Application myApplication){
            application = myApplication;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)  new HomeViewModel(application);
        }
    }
}
