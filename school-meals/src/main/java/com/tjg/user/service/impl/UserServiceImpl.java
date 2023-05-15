package com.tjg.user.service.impl;

import com.tjg.entity.*;
import com.tjg.user.cache.UserCache;
import com.tjg.user.dao.UserDao;
import com.tjg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserCache userCache;
    public User selectByNameAndPwd(String username, String password) {
        // tested OK
        userCache.selectByNameAndPwd(username, password);
        return userDao.selectByNameAndPwd(username, password);
    }

    public List<Merchant> findMerchant(long cid) {
        return userDao.findMerchant(cid);
    }

    public List<Food> findFoodDetail(long mid) {
        return userDao.findFoodDetail(mid);
    }

    public Food findFood(long fid) {
        return userDao.findFood(fid);
    }

    public int addOrder(Orders order) {
        return userDao.addOrder(order);
    }

    public int addOrderItem(OrderItem orderItem) {
        return userDao.addOrderItem(orderItem);
    }

    public Orders findOrder(long oid) {
        return userDao.findOrder(oid);
    }

    public int pay(float total, long uid) {
        return userDao.pay(total, uid);
    }

    public List<Orders> findOrders(long uid) {
        return userDao.findOrders(uid);
    }

    public int over(long oid) {
        return userDao.over(oid);
    }

    public List<OrderItem> orderDetail(long oid) {
        return userDao.orderDetail(oid);
    }


}
