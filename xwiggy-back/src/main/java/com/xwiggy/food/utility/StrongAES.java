package com.xwiggy.food.utility;

import org.springframework.beans.factory.annotation.Value;

public class StrongAES {

    @Value("${AES.Key}")
    private String AESKey;

    public String encrypt(String password){
        return this.AESKey;
    }
}

class Check{
    public static void main(String[] args) {
        StrongAES strongAES = new StrongAES();
        System.out.println(strongAES.encrypt("aman"));
    }
}
