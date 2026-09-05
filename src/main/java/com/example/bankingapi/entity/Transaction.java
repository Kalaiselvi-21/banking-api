package com.example.bankingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double amount;
    @ManyToOne
    private BankAccount account;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setAccount(BankAccount account){
        this.account = account;
    }
    public BankAccount getAccount(){
        return account;
    }

}
