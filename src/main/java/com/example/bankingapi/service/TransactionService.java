package com.example.bankingapi.service;

import com.example.bankingapi.dto.TransactionRequest;
import com.example.bankingapi.entity.BankAccount;
import com.example.bankingapi.entity.Transaction;
import com.example.bankingapi.exception.ResourceNotFoundException;
import com.example.bankingapi.repository.BankAccountRepository;
import com.example.bankingapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    public TransactionService(TransactionRepository transactionRepository, BankAccountRepository bankAccountRepository){
        this.transactionRepository = transactionRepository;
        this.bankAccountRepository = bankAccountRepository;
    }
    public Transaction createTransaction(Long accountId, TransactionRequest request){
        BankAccount account = bankAccountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found with this id " + accountId));
        Transaction transaction = new Transaction();
        transaction.setType(request.getType());
        transaction.setAmount(request.getAmount());
        transaction.setAccount(account);
        return transactionRepository.save(transaction);
    }
    public List<Transaction> getTransactionsByAccount(Long accountId){
        if(!bankAccountRepository.existsById(accountId)){
            throw new ResourceNotFoundException("Account not found with this id " + accountId);
        }
        return transactionRepository.findByAccount_Id(accountId);
    }
}
