package com.tjg.user.cache;

import com.tjg.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Repository
public class UserCache {
    @Autowired
    JedisPool jedisPool;
    public User selectByNameAndPwd(String username, String password) {
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys("*");
        System.out.println("keys: " + keys);
        jedis.close();
        return null;
    }

    public int checkInventory(long fid) {
        Jedis jedis = jedisPool.getResource();
        int inventory = Integer.parseInt(jedis.get(String.valueOf(fid)));
        jedis.close();
        return inventory;
    }

    public long decrInventory(long fid, int count) {
        Jedis jedis = jedisPool.getResource();
        long inventory = jedis.decrBy(String.valueOf(fid), count);
        jedis.close();
        return inventory;
    }
}