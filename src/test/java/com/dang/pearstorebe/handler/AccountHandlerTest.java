package com.dang.pearstorebe.handler;

import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
import com.dang.pearstorebe.accountService.handler.AccountHandler;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountHandlerTest {
    @InjectMocks
    private AccountHandler accountHandler;

    @Test
    public void receiveAccountCreated_success(){
        ConsumerRecord<String, SpecificRecord> consumerRecord = new ConsumerRecord<>(
                "",
                0,
                0,
                "AccountCreated",
                new AccountCreated()
                );
        AccountCreated accountCreated = accountHandler.handleCreated(consumerRecord);
        assertThat(accountCreated).isNotNull();
    }

    @Test
    public void receiveAccountCreationFailed_success(){
        ConsumerRecord<String, SpecificRecord> consumerRecord = new ConsumerRecord<>(
                "",
                0,
                0,
                "AccountCreationFailed",
                new AccountCreationFailed()
        );
        AccountCreationFailed accountCreationFailed = accountHandler.handleFailed(consumerRecord);
        assertThat(accountCreationFailed).isNotNull();
    }
}
