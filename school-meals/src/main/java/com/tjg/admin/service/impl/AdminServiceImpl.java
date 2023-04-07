package com.tjg.admin.service.impl;

import com.tjg.admin.cache.AdminCache;
import com.tjg.admin.dao.AdminDao;
import com.tjg.admin.service.AdminService;
import com.tjg.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //注入service依赖
    @Autowired
    AdminDao adminDao;
    @Autowired
    AdminCache adminCache;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    public Admin selectByNameAndPwd(String username, String password) {
        return adminDao.selectByNameAndPwd(username,password);
    }

    /**
     * 查询所有店铺
     * @return
     */
    public List<Merchant> selectFindAllMerchant() {
        System.out.println("mmmmmmmmsssssss");
//        return adminDao.selectFindAllMerchant();
        return adminCache.selectFindAllMerchant();
    }

    /**
     * 根据cid查询店铺
     * @param cid
     * @return
     */
    public List<Merchant> selectFindMerchant(long cid) {
        return adminDao.selectFindMerchant(cid);
    }

    /**
     * 添加店铺
     * @param merchant
     */
    public int addMerchant(Merchant merchant) {
        return adminDao.addMerchant(merchant);
    }

    /**
     * 查询所有分类
     * @return
     */
    public List<Category> findAllCategory() {
        return adminDao.findAllCategory();
    }

    /**
     * 查询所有订单
     * @return
     */
    public List<Orders> findAllOrders() {
        return adminDao.findAllOrders();
    }

    public List<OrderItem> findOrders(long oid) {
        return adminDao.findOrders(oid);
    }

    /**
     * 添加食物
     * @param food
     * @return
     */
    public int addFood(Food food) {
        return adminDao.addFood(food);
    }

    /**
     * 查找食物
     * @param mid
     * @return
     */
    public List<Food> findFoodDetail(long mid) {
        return adminDao.findFoodDetail(mid);
    }

    /**
     * 删除店铺
     * @param mid
     * @return
     */
    public int deleteMerchant(long mid) {
        return adminDao.deleteMerchant(mid);
    }

    /**
     * 删除食物
     * @param fid
     * @return
     */
    public int deleteFood(long fid) {
        return adminDao.deleteFood(fid);
    }

    public Orders findOrder(long oid) {
        return adminDao.findOrder(oid);
    }

}
