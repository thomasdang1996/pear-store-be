package com.dang.pearstorebe.accountService.controller;

import com.dang.pearstorebe.accountService.dto.CreateAccountRequest;
import com.dang.pearstorebe.accountService.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pear-store-be/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    /**
     * Sends a message request for adding new account
     *
     * @param createAccountRequest request body. Validation to be added
     * @return OK
     */
    @PostMapping()
    public ResponseEntity<CreateAccountRequest> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        accountService.createAccount(createAccountRequest);
        return ResponseEntity.ok().build();
    }

}
