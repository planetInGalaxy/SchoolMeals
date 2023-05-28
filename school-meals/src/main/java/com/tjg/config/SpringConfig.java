package com.tjg.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;


@Configuration
public class SpringConfig {
    @Bean
    public JedisPool jedisPool(){
        //0.创建一个配置对象来配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);//最大连接对象
        config.setMaxIdle(10);//最大闲置对象
        //1.创建Jedis连接池对象
        return new JedisPool(config, "localhost", 6379, 10000);
    }

//    @Bean
//    @Scope("prototype")
//    public Jedis jedis() {
//        // 客户端
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        System.out.println("+++++++++\n" + jedis.hashCode());
//        return jedis;
//    }

    @Bean
    public KafkaProducer<String, Object> kafkaProducer() throws IOException {
        return new KafkaProducer<>(PropUtils.load("kafka-producer.properties"));
    }

    @Bean
    public KafkaConsumer<String, Object> kafkaConsumer() throws IOException {
        return new KafkaConsumer<>(PropUtils.load("kafka-consumer.properties"));
    }

}
