package com.jennifer.ef_torrespalomino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jennifer.ef_torrespalomino.databinding.ActivityFavoriteBinding;

public class FavoriteActivity extends AppCompatActivity {
    private ActivityFavoriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}

