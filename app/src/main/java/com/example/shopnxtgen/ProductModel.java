package com.example.shopnxtgen;

public class ProductModel {
    private String id;
    private String Product_Description;
    private String Product_Name;
    private String Image; // make is int if app crashes
    private Boolean show;

    public ProductModel() {
        // empty Constructor
    }

    public ProductModel(String id, String product_Description, String product_Name, String image, Boolean show) {
        this.id = id;
        Product_Description = product_Description;
        Product_Name = product_Name;
        Image = image;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_Description() {
        return Product_Description;
    }

    public void setProduct_Description(String product_Description) {
        Product_Description = product_Description;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
