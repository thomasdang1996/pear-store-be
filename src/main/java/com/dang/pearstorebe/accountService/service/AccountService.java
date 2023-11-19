package com.dang.pearstorebe.accountService.service;

import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
import avrogenerated.accountmanager.CreateAccountPayload;
import com.dang.commonlib.messaging.MessageBus;
import com.dang.commonlib.messaging.enums.HeaderEnum;
import com.dang.commonlib.transaction.AsyncManager;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.mapper.AccountManagerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final MessageBus messageBus;
    private final AccountManagerMapper mapper;
    private final AsyncManager asyncManager;

    public ResponseEntity<String> createAccount(CreateAccountRequest createAccountRequest) {
        CreateAccountPayload payload = mapper.toCreateAccountPayload(createAccountRequest);
        UUID messageId = UUID.randomUUID();
        long transactionId = asyncManager.registerTransaction(messageId, payload);

        messageBus.sendMessage(
                payload,
                Map.of(HeaderEnum.MESSAGE_ID, messageId.toString())
        );

        asyncManager.waitForSync(transactionId);
        Object replyMessage = asyncManager.getReplyMessage(messageId);
        if (replyMessage instanceof AccountCreated)
            return ResponseEntity.ok("Account was successfully created");
        else {
            AccountCreationFailed failed = (AccountCreationFailed) replyMessage;
            return ResponseEntity.badRequest().body(failed.getMessage());
        }
    }
}
