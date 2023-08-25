package com.jennifer.ef_torrespalomino.model;

public class Product {
        private int id;
        private String title;
        private double price;
        private String image;
        private String description;
        private String category;

        public Product(int id, String title, double price, String image,
                       String description, String category) {
                this.id = id;
                this.title = title;
                this.price = price;
                this.image = image;
                this.description = description;
                this.category = category;
        }

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

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
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
}
