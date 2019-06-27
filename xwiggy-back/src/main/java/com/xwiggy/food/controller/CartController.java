package com.xwiggy.food.controller;

import com.xwiggy.food.dao.CartDaoImpl;
import com.xwiggy.food.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    CartDaoImpl cartDao;

    @PostMapping("/cart")
    public int getTotal(@RequestBody Cart cart, Model model){
        Cart cart1 = cart;
        cartDao.saveToCart(cart1);
        return (cart1.getQuantity1()*50)+(cart1.getQuantity2()*20)+(cart1.getQuantity3()*80);
    }

    @RequestMapping("/changeDB")
    public boolean changeDB(){
        cartDao.updateDB();
        return true;
    }

}
