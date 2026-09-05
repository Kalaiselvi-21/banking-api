package com.example.bankingapi.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;

public class AccountRequest {
    @NotBlank(message = "Account Number is required")
    private String accountNumber;
    @NotBlank(message = "Account Type is required")
    private String accountType;
    @PositiveOrZero(message = "Balance cannot be negative")
    private double balance;
    @NotNull(message = "Customer Id is required")
    private Long customerId;
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    public String getAccountType(){
        return accountType;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }
    public Long getCustomerId(){
        return customerId;
    }
}
