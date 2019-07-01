package com.xwiggy.food.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private int phone;
    private boolean merchant;

    public User() {

    }

    public User(String username, String password, String firstname, String lastname, String email, String address, int phone,
                boolean merchant) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.merchant=merchant;
    }

    public boolean isMerchant() {
        return merchant;
    }

    public void setMerchant(boolean merchant) {
        this.merchant = merchant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("username: " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        System.out.println("firstname: " + firstname);
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        System.out.println("lastname: " + lastname);
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", merchant=" + merchant +
                '}';
    }
}
