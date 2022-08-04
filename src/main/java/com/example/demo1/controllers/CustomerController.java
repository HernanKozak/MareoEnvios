package com.example.demo1.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.models.CustomerModel;
import com.example.demo1.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public Optional<CustomerModel> getCustomerById(@PathVariable("id") Integer id){
        return this.customerService.getCustomerById(id);
    }

}