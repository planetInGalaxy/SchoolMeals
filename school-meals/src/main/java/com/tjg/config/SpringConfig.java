package com.tjg.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringConfig {
    @Bean
    public Jedis jedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("Reids OK");
        return jedis;
    }

    @Bean
    public KafkaProducer<String, Object> kafkaProducer() throws IOException {
        return new KafkaProducer<>(PropUtils.load("kafka-producer.properties"));
    }

}
