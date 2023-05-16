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

    public int checkInventory(long fid) {
        return Integer.parseInt(jedis.get(String.valueOf(fid)));
    }

    public long decrInventory(long fid, int count) {
        return jedis.decrBy(String.valueOf(fid), count);
    }
}