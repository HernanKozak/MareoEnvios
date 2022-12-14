package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.models.ShippingModel;
import com.example.demo1.repositories.ShippingRepository;

@Service
public class ShippingService {
    
    @Autowired
    ShippingRepository ShippingRepository;

    public Optional<ShippingModel> getShippingById(int id){
        return ShippingRepository.findById(id);
    }

    public ShippingModel save(ShippingModel shipping){
        return ShippingRepository.save(shipping);
    }

    public Optional<ShippingModel> changeStatus(int id, String statusNew){
        Optional<ShippingModel> shippingOp = getShippingById(id);

        if(shippingOp.isPresent()){
            ShippingModel shipping = shippingOp.get();
            String statusOriginal = shipping.getState();
            //If the status is "Entregado" or "Cancelado" there is no possible transition so nothing to make.
            if(!statusOriginal.equals("Entregado") && !statusOriginal.equals("Cancelado")){

                //Inside each status if it asks of every possible transition. If the one recieved is not possible nothing to do.
                if(statusOriginal.equals("Inicial")){
                    if(statusNew.equals("sendToMail")){
                        shipping.setState("Entregado al correo");
                    }
                    if(statusNew.equals("cancelled")){
                        shipping.setState("Cancelado");   
                    }
                }
                if(statusOriginal.equals("Entregado al correo")){
                    if(statusNew.equals("inTravel")){
                        shipping.setState("En camino");
                    }
                    if(statusNew.equals("cancelled")){
                        shipping.setState("Cancelado");         
                    }
                }
                if(statusOriginal.equals("En camino")){
                    if(statusNew.equals("delivered")){
                        shipping.setState("Entregado");
                        shipping.setArrive_date(new java.util.Date());
                    }
                }
                save(shipping);
            }
        }
        return shippingOp;
    }
}