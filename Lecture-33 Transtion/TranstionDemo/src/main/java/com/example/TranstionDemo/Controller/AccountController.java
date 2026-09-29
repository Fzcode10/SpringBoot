package com.example.TranstionDemo.Controller;

import com.example.TranstionDemo.Model.AccountDetails;
import com.example.TranstionDemo.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ac")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountDetails accountDetails){
        accountService.createAccount(accountDetails);
        return ResponseEntity.ok("Done");
    }

}
