package com.tjg.user.cache;

import com.tjg.entity.*;
import com.tjg.user.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserCache implements UserDao {
    @Override
    public User selectByNameAndPwd(String username, String password) {
        return null;
    }

    @Override
    public List<Merchant> findMerchant(long cid) {
        System.out.println("fM");
        List<Merchant> list = new ArrayList<>();
        Merchant merchant = new Merchant();
        merchant.setMid(11);
        merchant.setMimage("chaocai.png");
        list.add(merchant);
        return list;
    }

    @Override
    public List<Food> findFoodDetail(long mid) {
        System.out.println("fFD");
        List<Food> list = new ArrayList<>();
        Food food = new Food();
        food.setFimage("baozi.png");
        list.add(food);
        return list;
    }

    @Override
    public Food findFood(long fid) {
        return null;
    }

    @Override
    public int addOrder(Orders order) {
        return 0;
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {
        return 0;
    }

    @Override
    public Orders findOrder(long oid) {
        return null;
    }

    @Override
    public int pay(float total, long uid) {
        return 0;
    }

    @Override
    public List<Orders> findOrders(long uid) {
        return null;
    }

    @Override
    public int over(long oid) {
        return 0;
    }

    @Override
    public List<OrderItem> orderDetail(long oid) {
        return null;
    }
}
