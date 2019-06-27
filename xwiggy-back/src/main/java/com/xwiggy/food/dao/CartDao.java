package com.xwiggy.food.dao;

import com.xwiggy.food.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
}
