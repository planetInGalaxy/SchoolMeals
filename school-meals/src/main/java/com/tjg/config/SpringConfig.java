package com.tjg.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import java.io.IOException;


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

    @Bean
    public KafkaConsumer<String, Object> kafkaConsumer() throws IOException {
        return new KafkaConsumer<>(PropUtils.load("kafka-consumer.properties"));
    }

}
