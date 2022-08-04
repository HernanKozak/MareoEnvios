package com.example.demo1.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.models.ProductModel;
import com.example.demo1.models.TopSentModel;
import com.example.demo1.models.ShippingAndProductModel;
import com.example.demo1.models.ShippingItemModel;
import com.example.demo1.models.ShippingModel;

//This service was created to keep the "original" services (the ones related to existing Models) as 
//simple as posible. 
@Service
public class ShippingAndProductService {

    @Autowired
    ProductService productService;

    @Autowired
    ShippingItemService shippingItemService;

    @Autowired
    ShippingService shippingService;

    public ShippingAndProductModel getShippingAndProducts(Integer id){
        ShippingAndProductModel shippingProducts = new ShippingAndProductModel();
        Optional<ShippingModel> shippingOp = shippingService.getShippingById(id);
        if(shippingOp.isPresent()){
            ShippingModel shipping = shippingOp.get();
            shippingProducts.setShipping(shipping);
            List<ShippingItemModel> shippingItem = shippingItemService.getShippingItemByShippingId(id);
            List<Integer> productsAmount = new ArrayList<Integer>();
            List<ProductModel> products = new ArrayList<ProductModel>();

            //Looping through the shippingItem list it adds all products related
            for(ShippingItemModel item: shippingItem){
                productsAmount.add(item.getProduct_count());
                Optional<ProductModel> productOp = productService.getProductById(item.getProduct_id());
                if(productOp.isPresent()){
                    products.add(productOp.get());
                }
            }
            shippingProducts.setProducts(products);
            shippingProducts.setProductsAmount(productsAmount);
            return shippingProducts;
        }
        return null; //It returns null if there was no shipping with the id specified
    }

    public List<TopSentModel> getTopSentProducts(int n){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<ShippingItemModel> shippingItems = shippingItemService.getAllShippingItem();

        //Looping through shippingItems this set the amount to the contain value if it's the first
        //product with that id to enter. Otherwise it sums the previous value to the new one
        for(ShippingItemModel item : shippingItems){
            if(map.putIfAbsent(item.getProduct_id(), item.getProduct_count()) != null){  
                int previousValue = map.get(item.getProduct_id());
                map.put(item.getProduct_id(), previousValue + item.getProduct_count());
            }
        }
        return getNTop(map, n);
    }

    private List<TopSentModel> getNTop(HashMap<Integer, Integer> map, int n){
        List<TopSentModel> topList = new ArrayList<TopSentModel>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> {return a.getValue()-b.getValue();});
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            queue.add(e);
            if(queue.size() > n){ //once the number of elements is exceded the littlest is poll off
                queue.poll();  
            }
        }

        //A Queue was used instead of sorting the List to keep the method more efficient
        while(!queue.isEmpty()){
            Map.Entry<Integer, Integer> topSentEntry =  queue.poll();
            int idProduct = topSentEntry.getKey();
            int amountProduct = topSentEntry.getValue();
            TopSentModel topSentProduct = new TopSentModel();
            topSentProduct.setAmount(amountProduct);
            Optional<ProductModel> product= productService.getProductById(idProduct);
            topSentProduct.setDescription(product.get().getDescription());
            topList.add(topSentProduct);
        }
        return topList;
    }    
}