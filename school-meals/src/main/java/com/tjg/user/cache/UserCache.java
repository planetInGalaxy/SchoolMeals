package com.tjg.user.cache;

import com.tjg.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserCache {
    @Autowired
    Jedis jedis;
    public User selectByNameAndPwd(String username, String password) {
        Set<String> keys = jedis.keys("*");
        System.out.println("keys: " + keys);
        return null;
    }

    public List<Merchant> findMerchant(long cid) {
        List<Merchant> list = new ArrayList<>();
        return list;
    }


    public List<Food> findFoodDetail(long mid) {
        List<Food> list = new ArrayList<>();
        return list;
    }


    public Food findFood(long fid) {
        return null;
    }


    public int addOrder(Orders order) {
        return 0;
    }


    public int addOrderItem(OrderItem orderItem) {
        return 0;
    }


    public Orders findOrder(long oid) {
        return null;
    }


    public int pay(float total, long uid) {
        return 0;
    }


    public List<Orders> findOrders(long uid) {
        return null;
    }


    public int over(long oid) {
        return 0;
    }


    public List<OrderItem> orderDetail(long oid) {
        return null;
    }
}