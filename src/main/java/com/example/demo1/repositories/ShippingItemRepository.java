package com.example.demo1.repositories;

import com.example.demo1.models.ShippingItemModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShippingItemRepository extends CrudRepository<ShippingItemModel, Integer>{
    

}