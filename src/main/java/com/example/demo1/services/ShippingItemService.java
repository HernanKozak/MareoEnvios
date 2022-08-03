package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.models.ShippingItemModel;
import com.example.demo1.repositories.ShippingItemRepository;

@Service
public class ShippingItemService {
    
    @Autowired
    ShippingItemRepository ShippingItemRepository;

}