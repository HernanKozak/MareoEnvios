package com.example.demo1.models;
import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductModel {
    
    @Id
    private int id;

    private String description;
    private float weight;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    
}