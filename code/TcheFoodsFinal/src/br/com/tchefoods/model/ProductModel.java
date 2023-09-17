package br.com.tchefoods.model;

public class ProductModel {
    private int id;
    private String name;

    private int categoryId;

    private float price;

    private String categoryDesc;

    public void setPrice(float price) {this.price = price;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }



}
