package com.example.TranstionDemo.Service;

import com.example.TranstionDemo.Model.AccountDetails;
import com.example.TranstionDemo.Model.TransferRecord;
import com.example.TranstionDemo.Repository.AccountRepository;
import com.example.TranstionDemo.Repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    TransferRepository transferRepository;
    AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository,
                            AccountRepository accountRepository){
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferAmount(
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount
                                ) throws Throwable {

        AccountDetails fromAccount =
                accountRepository.findById(fromAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        AccountDetails toAccount =
                accountRepository.findById(toAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        accountRepository.saveAndFlush(fromAccount);

        toAccount.creditAccount(amount);
        accountRepository.saveAndFlush(toAccount);

        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));
        transferRepository.flush();

//        throw new RuntimeException("Some Error Occurred");
    }
}
