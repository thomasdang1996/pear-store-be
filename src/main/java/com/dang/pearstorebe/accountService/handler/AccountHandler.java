package com.dang.pearstorebe.accountService.handler;


import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
import com.dang.commonlib.messaging.MessageUtils;
import com.dang.commonlib.messaging.enums.HeaderEnum;
import com.dang.commonlib.transaction.TransactionSynchronizer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * Class responsible for handling messages
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AccountHandler {
    private final TransactionSynchronizer transactionSynchronizer;

    @KafkaListener(
            topics = "${com.dang.commonlib.messaging.avrogenerated.accountmanager.AccountCreated.topic}",
            groupId = "pear-store-be-group"
    )
    public AccountCreated handleCreated(ConsumerRecord<String, SpecificRecord> message) {
        log.info("Received {}: {}", message.getClass().getCanonicalName(), message);
        Map<HeaderEnum,String> header= MessageUtils.toHeaderMap(message.headers());
        UUID messageID = UUID.fromString(header.get(HeaderEnum.MESSAGE_ID));
        transactionSynchronizer.resume(messageID);
        return  (AccountCreated) message.value();
    }

    @KafkaListener(
            topics = "${com.dang.commonlib.messaging.avrogenerated.accountmanager.AccountCreationFailed.topic}",
            groupId = "pear-store-be-group"
    )
    public AccountCreationFailed handleFailed(ConsumerRecord<String, SpecificRecord> message) {
        log.info("Received {}: {}", message.getClass().getCanonicalName(), message);
        UUID messageId = UUID.fromString(new String(message.headers().toArray()[0].value()));
        transactionSynchronizer.resume(messageId);
        return (AccountCreationFailed) message.value();
    }
}
