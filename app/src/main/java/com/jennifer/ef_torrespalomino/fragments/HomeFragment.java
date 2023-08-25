package com.jennifer.ef_torrespalomino.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jennifer.ef_torrespalomino.R;
import com.jennifer.ef_torrespalomino.data.retrofit.ProductsInterface;
import com.jennifer.ef_torrespalomino.data.retrofit.RetrofitHelper;
import com.jennifer.ef_torrespalomino.databinding.FragmentHomeBinding;
import com.jennifer.ef_torrespalomino.model.Product;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_product);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        binding.rvProduct.setLayoutManager(layoutManager);

        ProductsInterface productsInterface = RetrofitHelper.getInstance().create(ProductsInterface.class);
        Call<List<Product>> call = productsInterface.getShowProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();
                showProduct(items);
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
            }
        });
    }

    private void showProduct(List<Product> showsList) {
        RVProductAdapter rvShowProductAdapter = new RVProductAdapter(showsList);
        recyclerView.setAdapter(rvShowProductAdapter);
    }
}