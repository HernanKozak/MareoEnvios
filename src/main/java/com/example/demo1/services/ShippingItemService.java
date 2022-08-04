package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.models.ShippingItemModel;
import com.example.demo1.repositories.ShippingItemRepository;

@Service
public class ShippingItemService {
    
    @Autowired
    ShippingItemRepository shippingItemRepository;

    //returns a list of all shippingItems with a given ShippingID
    public List<ShippingItemModel> getShippingItemByShippingId(Integer idShipping){
        List<ShippingItemModel> shippingItemsList = new ArrayList<ShippingItemModel>();
        Iterable<ShippingItemModel> allShippingItems = this.shippingItemRepository.findAll();

        for(ShippingItemModel shippingItem: allShippingItems){
            if(shippingItem.getShipping_id() == idShipping){
                shippingItemsList.add(shippingItem);
            }
        }
        return shippingItemsList;
    }

    public List<ShippingItemModel> getAllShippingItem(){
        return (List<ShippingItemModel>) shippingItemRepository.findAll();
    }

}