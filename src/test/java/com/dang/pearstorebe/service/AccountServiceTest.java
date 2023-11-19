package com.dang.pearstorebe.service;


import avrogenerated.accountmanager.AccountCreationFailed;
import avrogenerated.accountmanager.CreateAccountPayload;
import com.dang.commonlib.messaging.MessageBus;
import com.dang.commonlib.messaging.enums.HeaderEnum;
import com.dang.commonlib.transaction.AsyncManager;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.service.AccountService;
import com.dang.pearstorebe.accountService.mapper.AccountManagerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountServiceTest {
    @Mock
    private MessageBus messageBus;
    @Mock
    private AsyncManager asyncManager;
    @Spy
    private AccountManagerMapper mapper = Mappers.getMapper(AccountManagerMapper.class);

    @InjectMocks
    private AccountService accountService;

    @Test
    public void createAccount_success() {
        UUID messageId = UUID.fromString("33aa1425-8328-4553-8beb-9c42a7952686");
        CreateAccountRequest createAccountRequest = CreateAccountRequest
                .builder()
                .username("someguy")
                .email("someguy@mail.com")
                .build();
        when(asyncManager.getReplyMessage(isA(UUID.class)))
                .thenReturn(new AccountCreationFailed());

        try(MockedStatic<UUID> uuid = Mockito.mockStatic(UUID.class)){
            uuid.when(UUID::randomUUID)
                    .thenReturn(messageId);
            accountService.createAccount(createAccountRequest);
        }

        verify(messageBus).sendMessage(new CreateAccountPayload("someguy", "someguy@mail.com"), Map.of(HeaderEnum.MESSAGE_ID,messageId.toString()));
    }
}
