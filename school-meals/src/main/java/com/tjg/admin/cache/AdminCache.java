package com.tjg.admin.cache;

import com.tjg.admin.dao.AdminDao;
import com.tjg.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminCache implements AdminDao {
    @Autowired
    Jedis jedis;
    @Override
    public Admin selectByNameAndPwd(String username, String password) {
        return null;
    }

    @Override
    public List<Merchant> selectFindAllMerchant() {
        System.out.println("cache......");
        List<Merchant> list = new ArrayList<>();
        Merchant merchant = new Merchant();
        merchant.setCid(100);
        list.add(merchant);
        return list;
    }

    @Override
    public List<Merchant> selectFindMerchant(long cid) {
        return null;
    }

    @Override
    public List<Category> findAllCategory() {
        return null;
    }

    @Override
    public int addMerchant(Merchant merchant) {
        return 0;
    }

    @Override
    public List<Orders> findAllOrders() {
        return null;
    }

    @Override
    public List<OrderItem> findOrders(long oid) {
        return null;
    }

    @Override
    public int addFood(Food food) {
        return 0;
    }

    @Override
    public List<Food> findFoodDetail(long mid) {
        return null;
    }

    @Override
    public int deleteMerchant(long mid) {
        return 0;
    }

    @Override
    public int deleteFood(long fid) {
        return 0;
    }

    @Override
    public Orders findOrder(long oid) {
        return null;
    }
}
