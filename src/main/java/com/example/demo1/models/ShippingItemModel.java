package com.example.demo1.models;
import javax.persistence.*;

@Entity
@Table(name = "Shipping_item")
public class ShippingItemModel {
    
    @Id
    private int id;
    
    private int shipping_id;
    private int product_id;
    private int product_count;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getShipping_id() {
        return shipping_id;
    }
    public void setShipping_id(int shipping_id) {
        this.shipping_id = shipping_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public int getProduct_count() {
        return product_count;
    }
    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    
}