package com.tjg.kafka;

import com.tjg.entity.User;
import com.tjg.user.cart.Cart;

public class KafkaMessage {
    private Cart cart;
    private User user;
    private String phone;
    private String address;

    public KafkaMessage(Cart cart, User user, String phone, String address) {
        this.cart = cart;
        this.user = user;
        this.phone = phone;
        this.address = address;
    }
    public KafkaMessage (){}
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
