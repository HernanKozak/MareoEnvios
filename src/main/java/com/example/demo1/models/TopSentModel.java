package com.example.demo1.models;


//Model created to store a Product description and its total amount sent
public class TopSentModel {
    private Integer amount;
    private String description;
    
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
