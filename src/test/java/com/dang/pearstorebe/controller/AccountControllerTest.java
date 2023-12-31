package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.accountService.controller.AccountController;
import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountControllerTest {
    @Mock
    private AccountService accountService;
    @InjectMocks
    private AccountController accountController;

    @Test
    public void createAccount_success() {
        CreateAccountRequest createAccountRequest = CreateAccountRequest
                .builder()
                .username("someguy")
                .email("someguy@mail.com")
                .build();
        when(accountService.createAccount(isA(CreateAccountRequest.class)))
                .thenReturn(ResponseEntity.ok().build());
        ResponseEntity<String> response = accountController.createAccount(createAccountRequest);

        assertThat(response)
                .isEqualTo(ResponseEntity.ok().build());
    }
}
