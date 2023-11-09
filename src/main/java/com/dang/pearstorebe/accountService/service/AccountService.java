package com.dang.pearstorebe.accountService.service;

import com.dang.commonlib.messaging.MessageBus;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.mapper.AccountManagerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final MessageBus messageBus;
    private final AccountManagerMapper mapper;

    public void createAccount(CreateAccountRequest createAccountRequest){
         messageBus.sendMessage(mapper.toCreateAccountPayload(createAccountRequest));
    }
}
