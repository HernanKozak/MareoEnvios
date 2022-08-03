package com.example.demo1.repositories;

import com.example.demo1.models.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Integer>{
    

}