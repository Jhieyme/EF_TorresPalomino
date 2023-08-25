package com.jennifer.ef_torrespalomino.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "showProduct")
public class ProductEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name= "show_title")
    public String title;

    @ColumnInfo(name= "show_price")
    public double price;

    @ColumnInfo(name= "show_description")
    public String description;

    @ColumnInfo(name =  "show_category")
    public String category;

    @ColumnInfo(name =  "banner")
    public String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}