package com.example.TranstionDemo.Controller;

import com.example.TranstionDemo.Model.TransferRecord;
import com.example.TranstionDemo.Service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    TransferService transferService;

    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferBalance(@RequestBody TransferRecord transferRecord) throws Throwable {

        Long fromAccountId = transferRecord.getFromAccountId();
        Long toAccountId = transferRecord.getToAccountId();
        BigDecimal amount = transferRecord.getAmount();

        System.out.println(fromAccountId+" "+toAccountId+" "+amount);

        transferService.transferAmount(fromAccountId, toAccountId, amount);

        return ResponseEntity.ok("Balance transfer");
    }

}
