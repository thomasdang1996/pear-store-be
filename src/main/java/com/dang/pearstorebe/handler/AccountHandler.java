package com.dang.pearstorebe.handler;


import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Class responsible for handling messages
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AccountHandler {
    @KafkaListener(
            topics = "${com.dang.commonlib.messaging.avrogenerated.accountmanager.AccountCreated.topic}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "pear-store-be-group"
    )
    public AccountCreated receive(AccountCreated message) {
        log.info("Data received: {}", message);
        return message;
    }

    @KafkaListener(
            topics = "${com.dang.commonlib.messaging.avrogenerated.accountmanager.AccountCreationFailed.topic}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "pear-store-be-group"
    )
    public AccountCreationFailed receive(AccountCreationFailed message) {
        log.info("Data received: {}", message);
        return message;
    }
}
