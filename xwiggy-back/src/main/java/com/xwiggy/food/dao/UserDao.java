package com.xwiggy.food.dao;

import com.xwiggy.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
}
