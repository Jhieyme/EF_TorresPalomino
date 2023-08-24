package com.jennifer.ef_torrespalomino.response;

import com.google.gson.annotations.SerializedName;
import com.jennifer.ef_torrespalomino.model.Product;

import java.util.List;

public class ShowProductResponse {

    @SerializedName("showProduct")

    public List<Product> showsList;

    public List<Product> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Product> showsList) {
        this.showsList = showsList;
    }

}