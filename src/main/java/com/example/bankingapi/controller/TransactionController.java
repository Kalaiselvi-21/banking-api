package com.example.bankingapi.controller;

import com.example.bankingapi.dto.TransactionRequest;
import com.example.bankingapi.entity.Transaction;
import com.example.bankingapi.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts/{accountId}/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @PostMapping
    public Transaction createTransaction(@PathVariable Long accountId, @Valid @RequestBody TransactionRequest request){
        return transactionService.createTransaction(accountId, request);
    }
    @GetMapping
    public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId){
        return transactionService.getTransactionsByAccount(accountId);
    }
}
