package com.example.demo1.models;
import javax.persistence.*;

@Entity
@Table(name = "Shipping")
public class ShippingModel {

    @Id
    private int id;
    
    private int customer_id;
    private String state;
    private java.util.Date send_date;
    private java.util.Date arrive_date;
    private int priority;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public java.util.Date getSend_date() {
        return send_date;
    }
    public void setSend_date(java.util.Date send_date) {
        this.send_date = send_date;
    }
    public java.util.Date getArrive_date() {
        return arrive_date;
    }
    public void setArrive_date(java.util.Date arrive_date) {
        this.arrive_date = arrive_date;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    
}   