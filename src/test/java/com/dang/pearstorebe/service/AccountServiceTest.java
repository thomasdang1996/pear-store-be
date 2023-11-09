package com.dang.pearstorebe.service;


import avrogenerated.accountmanager.CreateAccountPayload;
import com.dang.commonlib.messaging.MessageBus;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.service.AccountService;
import com.dang.pearstorebe.accountService.mapper.AccountManagerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountServiceTest {
    @Mock
    private MessageBus messageBus;
    @Spy
    private AccountManagerMapper mapper = Mappers.getMapper(AccountManagerMapper.class);

    @InjectMocks
    private AccountService accountService;

    @Test
    public void createAccount_success(){
        CreateAccountRequest createAccountRequest = CreateAccountRequest
                .builder()
                .username("someguy")
                .email("someguy@mail.com")
                .build();

        accountService.createAccount(createAccountRequest);
        verify(messageBus).sendMessage(new CreateAccountPayload("someguy","someguy@mail.com"));
    }
}
