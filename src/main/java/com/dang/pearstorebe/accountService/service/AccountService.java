package com.dang.pearstorebe.accountService.service;

import com.dang.commonlib.messaging.MessageBus;
import com.dang.commonlib.transaction.TransactionSynchronizer;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.mapper.AccountManagerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final MessageBus messageBus;
    private final AccountManagerMapper mapper;
    private final TransactionSynchronizer transactionSynchronizer;

    public void createAccount(CreateAccountRequest createAccountRequest) {
        UUID messageId = UUID.randomUUID();
        messageBus.sendMessage(
                mapper.toCreateAccountPayload(createAccountRequest),
                List.of(new RecordHeader("messageId", messageId.toString().getBytes()))
        );
        long transactionId = transactionSynchronizer.registerTransaction(messageId);
        transactionSynchronizer.waitForSync(transactionId);
    }
}
