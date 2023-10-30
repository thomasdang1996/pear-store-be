package com.dang.pearstorebe.service;

import com.dang.commonlib.messaging.MessageBus;
import com.dang.pearstorebe.dto.CreateAccountRequest;
import com.dang.pearstorebe.mapper.AccountManagerMapper;
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
