package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.dto.CreateAccountRequest;
import com.dang.pearstorebe.service.AccountService;
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
    @PostMapping()
    public ResponseEntity<CreateAccountRequest> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        accountService.createAccount(createAccountRequest);
        return ResponseEntity.ok().build();
    }

}
