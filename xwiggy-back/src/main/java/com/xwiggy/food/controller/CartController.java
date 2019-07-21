package com.xwiggy.food.controller;

import com.xwiggy.food.dao.CartDaoImpl;
import com.xwiggy.food.model.Cart;
import com.xwiggy.food.model.NewCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    CartDaoImpl cartDao;


    @PostMapping("/cart")
    public int getTotal(@RequestBody NewCart[] cart, Model model){
        cartDao.saveToCart(cart);
        return cartDao.claculateTotal(cart);
    }

    @RequestMapping("/changeDB")
    public boolean changeDB(){
        cartDao.updateDB();
        return true;
    }

    @PostMapping("/addToCart")
    public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model){
        cartDao.addItems(cart);
        return cart;
    }

    @PostMapping("/addNewItem")
    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDao.addNewItem(file,newFoodData);
    }


    @PostMapping("/addNewItemUrl")
    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDao.addNewItemWithUrl(newFoodData);
    }

    @PostMapping("/checkItemId")
    public boolean checkItemId(@RequestBody String itemId, Model model){
        return !cartDao.itemIdAvailable(itemId);
    }
}
