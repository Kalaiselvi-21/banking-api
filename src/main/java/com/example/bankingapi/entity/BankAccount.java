package com.example.bankingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String accountType;
    private double balance;
    @ManyToOne
    private Customer customer;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
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
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer(){
        return customer;
    }
}
