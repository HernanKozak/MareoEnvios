package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.models.CustomerModel;
import com.example.demo1.repositories.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public Optional<CustomerModel> getCustomerById(int id){
        return customerRepository.findById(id);
    }
}