package com.dang.pearstorebe.handler;

import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
import com.dang.commonlib.transaction.AsyncManager;
import com.dang.pearstorebe.accountService.handler.AccountHandler;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.dang.commonlib.messaging.enums.HeaderEnum.MESSAGE_ID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountHandlerTest {
    @Mock
    private AsyncManager asyncManager;
    @InjectMocks
    private AccountHandler accountHandler;

    @Test
    public void receiveAccountCreated_success(){
        UUID messageId = UUID.fromString("7796ec29-87ce-445a-8f77-23e68a99973c");
        ConsumerRecord<String, SpecificRecord> consumerRecord = new ConsumerRecord<>(
                "",
                0,
                0,
                "AccountCreated",
                new AccountCreated()
                );
        consumerRecord.headers().add(MESSAGE_ID.getCode(),messageId.toString().getBytes());
        AccountCreated accountCreated = accountHandler.handleCreated(consumerRecord);
        assertThat(accountCreated).isNotNull();
    }

    @Test
    public void receiveAccountCreationFailed_success(){
        UUID messageId = UUID.fromString("7796ec29-87ce-445a-8f77-23e68a99973c");
        ConsumerRecord<String, SpecificRecord> consumerRecord = new ConsumerRecord<>(
                "",
                0,
                0,
                "AccountCreationFailed",
                new AccountCreationFailed()
        );
        consumerRecord.headers().add(MESSAGE_ID.getCode(),messageId.toString().getBytes());

        AccountCreationFailed accountCreationFailed = accountHandler.handleFailed(consumerRecord);
        assertThat(accountCreationFailed).isNotNull();
    }
}
