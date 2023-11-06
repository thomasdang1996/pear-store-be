package com.dang.pearstorebe.handler;

import avrogenerated.accountmanager.AccountCreated;
import avrogenerated.accountmanager.AccountCreationFailed;
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
        AccountCreated accountCreated = accountHandler.receive(new AccountCreated());
        assertThat(accountCreated).isNotNull();
    }

    @Test
    public void receiveAccountCreationFailed_success(){
        AccountCreationFailed accountCreationFailed = accountHandler.receive(new AccountCreationFailed());
        assertThat(accountCreationFailed).isNotNull();
    }
}
