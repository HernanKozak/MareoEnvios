package com.example.demo1.repositories;

import com.example.demo1.models.ShippingModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShippingRepository extends CrudRepository<ShippingModel, Integer>{
    

}