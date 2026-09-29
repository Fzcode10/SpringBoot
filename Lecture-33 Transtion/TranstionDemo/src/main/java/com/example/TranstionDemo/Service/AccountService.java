package com.example.TranstionDemo.Service;

import com.example.TranstionDemo.Model.AccountDetails;
import com.example.TranstionDemo.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void createAccount(AccountDetails accountDetails){
        accountRepository.save(accountDetails);
    }
}
