package com.example.demo1.models;

import java.util.List;

public class ShippingAndProductModel{
    private ShippingModel shipping;
    private List<ProductModel> products;
    private List<Integer> productsAmount;

    public List<Integer> getProductsAmount() {
        return productsAmount;
    }
    public void setProductsAmount(List<Integer> productsAmount) {
        this.productsAmount = productsAmount;
    }
    public ShippingModel getShipping() {
        return shipping;
    }
    public void setShipping(ShippingModel shipping) {
        this.shipping = shipping;
    }
    public List<ProductModel> getProducts() {
        return products;
    }
    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
    
}