package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.models.ProductModel;
import com.example.demo1.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository ProductRepository;

    public Optional<ProductModel> getProductById(int id){
        return ProductRepository.findById(id);
    }
    
}