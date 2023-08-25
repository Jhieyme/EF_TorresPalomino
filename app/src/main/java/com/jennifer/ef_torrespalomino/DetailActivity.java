package com.jennifer.ef_torrespalomino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jennifer.ef_torrespalomino.databinding.ActivityDetailBinding;
import com.jennifer.ef_torrespalomino.db.ProductRepository;
import com.jennifer.ef_torrespalomino.model.ProductEntity;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recibe los datos del producto del Intent
        String title = getIntent().getStringExtra("title");
        double price = getIntent().getDoubleExtra("price", 0.0);
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");

        binding.txtName.setText(title);
        binding.txtprecio.setText(String.format("S/. %.2f", price));
        binding.txtDescrip.setText(description);
        binding.txtCategoria.setText(category);
        Glide.with(this).load(image).into(binding.imgShowDetail);


        productRepository = new ProductRepository(getApplication());
        binding.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setTitle(title);
                productEntity.setPrice(price);
                productEntity.setDescription(description);
                productEntity.setCategory(category);
                productEntity.setImage(image);
                productRepository.addProduct(productEntity);

                Toast.makeText(DetailActivity.this, "Producto agregado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}