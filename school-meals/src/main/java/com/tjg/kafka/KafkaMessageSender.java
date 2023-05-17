package com.tjg.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageSender {
    @Autowired
    private KafkaProducer kafkaProducer;
    public boolean sendMessage(String msg){
        ProducerRecord<String, String> record = new ProducerRecord<>("takeout", msg);
        kafkaProducer.send(record);
        System.out.println("sent");
        return true;
    }
}
