package com.jennifer.ef_torrespalomino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.jennifer.ef_torrespalomino.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

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
    }
}