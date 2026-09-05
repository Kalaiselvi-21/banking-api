package com.example.bankingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TransactionRequest {
    @NotBlank(message = "Transaction Type is required")
    private String type;
    @Positive(message = "Transaction amount must be greater than zero")
    private double amount;
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
}
