package com.tjg.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjg.user.controller.UserController;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

//@Slf4j
@Component
public class KafkaMessageDispatcher {

    @Autowired
    private KafkaConsumer<String, Object> kafkaConsumer;
    @Autowired
    UserController userController;
    @PostConstruct
    public void dispatcher() {
        kafkaConsumer.subscribe(Collections.singleton("takeout"));
        try {
            new Thread(() -> {
                while (true) {
                    ConsumerRecords<String, Object> records = kafkaConsumer.poll(Duration.ofMillis(100));
                    handlerRecord(records);
                }
            }).start();
        } catch (Exception e) {
            errHandler(e);
        }
    }

    private void handlerRecord(ConsumerRecords<String, Object> records) {
        records.forEach(r -> {
//            log.info("handler record:topic[{}],offset[{}],partition[{}],key[{}],val[{}]",
//                    r.topic(), r.offset(), r.partition(), r.key(), r.value());
            System.out.println("received");
            System.out.println(r.topic());
            System.out.println(r.offset());
            System.out.println(r.partition());
            System.out.println(r.key());
            System.out.println(r.value());
            System.out.println("----------------");
            try {
                System.out.println("prasing...");
                ObjectMapper objectMapper = new ObjectMapper();
                KafkaMessage kafkaMessage = objectMapper.readValue(r.value().toString(), KafkaMessage.class);
                System.out.println("prased.");
                userController.addOrder2(kafkaMessage.getCart(), kafkaMessage.getUser(), kafkaMessage.getPhone(), kafkaMessage.getAddress());
                System.out.println("consumed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    private void errHandler(Exception e) {
        // todo
//        log.info(e.getMessage());
    }

}
