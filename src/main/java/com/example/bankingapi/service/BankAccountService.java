package com.example.bankingapi.service;
import com.example.bankingapi.dto.AccountRequest;
import com.example.bankingapi.entity.BankAccount;
import com.example.bankingapi.entity.Customer;
import com.example.bankingapi.exception.ResourceNotFoundException;
import com.example.bankingapi.repository.CustomerRepository;
import com.example.bankingapi.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BankAccountService {
private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
public BankAccountService(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
    this.bankAccountRepository = bankAccountRepository;
    this.customerRepository = customerRepository;
}
public BankAccount createAccount(AccountRequest request){
    Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found with this id "+ request.getCustomerId()));
    BankAccount account = new BankAccount();
    account.setAccountNumber(request.getAccountNumber());
    account.setAccountType(request.getAccountType());
    account.setBalance(request.getBalance());
    account.setCustomer(customer);
    return bankAccountRepository.save(account);
}
public List<BankAccount> getAllAccounts(){
    return bankAccountRepository.findAll();
}
public BankAccount getAccountById(Long id){
    return bankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with this id " + id));
}
}

