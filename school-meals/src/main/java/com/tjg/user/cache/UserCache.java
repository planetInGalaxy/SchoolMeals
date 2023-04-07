package com.tjg.user.cache;

import com.tjg.entity.*;
import com.tjg.user.dao.UserDao;

import java.util.List;

public class UserCache implements UserDao {
    @Override
    public User selectByNameAndPwd(String username, String password) {
        return null;
    }

    @Override
    public List<Merchant> findMerchant(long cid) {
        return null;
    }

    @Override
    public List<Food> findFoodDetail(long mid) {
        return null;
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
