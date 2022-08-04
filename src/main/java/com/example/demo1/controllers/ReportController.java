package com.example.demo1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.models.TopSentModel;
import com.example.demo1.services.ShippingAndProductService;

@RestController
@RequestMapping("/reports")
public class ReportController {
    
    @Autowired
    ShippingAndProductService shippingAndProductService;

    @GetMapping("/top-sent")
    public List<TopSentModel> getTopSent(){
        int topAmount = 3;
        return shippingAndProductService.getTopSentProducts(topAmount);
    }

}