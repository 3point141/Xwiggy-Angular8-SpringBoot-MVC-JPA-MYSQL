package com.xwiggy.food.dao;

import com.xwiggy.food.model.Cart;
import com.xwiggy.food.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDaoImpl{

    @Autowired
    CartDao cartDao;

    @Autowired
    FoodDao foodDao;

    public void saveToCart(Cart cart){
        cartDao.deleteAll();
        cartDao.flush();
        cartDao.save(cart);
    }

    public void updateDB(){
        List<Cart> carts =cartDao.findAll();
        Cart cart = carts.get(1);
        List<Food> foods = foodDao.findAll();
        foods.get(0).setQuantity(foods.get(0).getQuantity()-cart.getQuantity1());
        foods.get(1).setQuantity(foods.get(1).getQuantity()-cart.getQuantity2());
        foods.get(2).setQuantity(foods.get(2).getQuantity()-cart.getQuantity3());

        foodDao.saveAll(foods);
    }

    public List<Cart> getAllCart(){
        return cartDao.findAll();
    }

    public void addItems(Cart cart){
        List<Food> foods = foodDao.findAll();
        foods.get(0).setQuantity(foods.get(0).getQuantity()+cart.getQuantity1());
        foods.get(1).setQuantity(foods.get(1).getQuantity()+cart.getQuantity2());
        foods.get(2).setQuantity(foods.get(2).getQuantity()+cart.getQuantity3());
        foodDao.saveAll(foods);
    }
}
