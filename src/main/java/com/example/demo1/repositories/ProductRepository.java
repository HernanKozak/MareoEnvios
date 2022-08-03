package com.example.demo1.repositories;

import com.example.demo1.models.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer>{
    
    
}