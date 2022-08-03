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

import com.example.demo1.models.ShippingModel;
import com.example.demo1.services.ShippingService;

@RestController
@RequestMapping("/Shipping")
public class ShippingController {
    
    @Autowired
    ShippingService ShippingService;

    @GetMapping("/{id}")
    public Optional<ShippingModel> getShippingById(@PathVariable("id") Integer id){
        return this.ShippingService.getShippingById(id);
    }

    @PatchMapping("/{id}")
    public Optional<ShippingModel> changeShippingStatus(@PathVariable("id") Integer id, @RequestBody Map<Object, Object> fields){
        String statusNew = (String) fields.get("transition");
        return this.ShippingService.changeStatus(id, statusNew);
    }


}