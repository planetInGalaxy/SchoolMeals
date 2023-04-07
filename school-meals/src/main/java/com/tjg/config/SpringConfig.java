package com.tjg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class SpringConfig {
    @Bean
    public Jedis jedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("Reids OK");
        return jedis;
    }
}
