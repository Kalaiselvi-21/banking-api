package com.example.bankingapi.controller;

import com.example.bankingapi.dto.AccountRequest;
import com.example.bankingapi.entity.BankAccount;
import com.example.bankingapi.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }
    @PostMapping
    public BankAccount createAccount(@Valid @RequestBody AccountRequest request){
        return bankAccountService.createAccount(request);

    }
    @GetMapping
    public List<BankAccount> getAllAccounts(){
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id){
        return bankAccountService.getAccountById(id);
    }
}
