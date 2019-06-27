package com.xwiggy.food.dao;

import com.xwiggy.food.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodDao extends JpaRepository<Food,String> {

}
