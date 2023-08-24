package com.jennifer.ef_torrespalomino.retrofit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jennifer.ef_torrespalomino.DetailActivity;
import com.jennifer.ef_torrespalomino.databinding.ItemShowBinding;
import com.jennifer.ef_torrespalomino.model.Product;


import java.util.List;

public class RVShowProductAdapter extends RecyclerView.Adapter<RVShowProductAdapter.ShowViewHolder>{

    private List<Product> products;

    public RVShowProductAdapter(List<Product> products){
        this.products = products;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowBinding binding = ItemShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowViewHolder(binding);
    }

    //Implementación del detalle ------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("title", product.getTitle());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image", product.getImage());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("category", product.getCategory());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {
        private ItemShowBinding binding;
        public ShowViewHolder(@NonNull ItemShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.txtName.setText(product.getTitle());
            binding.txtPrecio.setText(String.format("S/. %.2f", product.getPrice()));
            Glide.with(itemView.getContext()).load(product.getImage()).into(binding.imgShow);
        }
    }

}
