package com.example.demo1.controllers;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.models.ShippingAndProductModel;
import com.example.demo1.models.ShippingModel;
import com.example.demo1.services.ShippingAndProductService;
import com.example.demo1.services.ShippingService;

@RestController
@RequestMapping("/shippings")
public class ShippingController {
    
    @Autowired
    ShippingService shippingService;

    @Autowired 
    ShippingAndProductService shippingAndProductService;

    @GetMapping("/{id}")
    public ShippingAndProductModel getShippingAndProductsById(@PathVariable("id") Integer id){
        return shippingAndProductService.getShippingAndProducts(id);
    }

    @PatchMapping("/{id}")
    public Optional<ShippingModel> changeShippingStatus(@PathVariable("id") Integer id, @RequestBody Map<Object, Object> fields){
        String statusNew = (String) fields.get("transition");
        return this.shippingService.changeStatus(id, statusNew);
    }

    


}