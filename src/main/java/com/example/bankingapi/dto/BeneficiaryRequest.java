package com.example.bankingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BeneficiaryRequest {
    @NotBlank(message = "Beneficiary name is required")
    private String name;
    @NotBlank(message = "Account Number is required")
    private String accountNumber;
    @NotNull(message = "Customer Id is required")
    private Long customerId;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }
    public Long getCustomerId (){
        return customerId ;
    }

}
