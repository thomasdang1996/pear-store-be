package com.dang.pearstorebe.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageBus {
    private final KafkaTemplate<String, SpecificRecord> kafkaTemplate;
    @Value("${app.kafka.producer.topic}")
    String topic;

    public void sendMessage(SpecificRecord record) {
        try {
            log.info("Sending message: {}", record);
            SendResult<String, SpecificRecord> result = kafkaTemplate
                    .send(topic, record)
                    .get();
            log.info("Message sent: {}", result.getProducerRecord());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}