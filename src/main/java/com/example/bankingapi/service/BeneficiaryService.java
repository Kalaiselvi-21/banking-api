package com.example.bankingapi.service;

import com.example.bankingapi.dto.BeneficiaryRequest;
import com.example.bankingapi.entity.Beneficiary;
import com.example.bankingapi.entity.Customer;
import com.example.bankingapi.exception.ResourceNotFoundException;
import com.example.bankingapi.repository.BeneficiaryRepository;
import com.example.bankingapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
    private final CustomerRepository customerRepository;
    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository, CustomerRepository customerRepository){
        this.beneficiaryRepository = beneficiaryRepository;
        this.customerRepository = customerRepository;
    }
    public Beneficiary createBeneficiary(BeneficiaryRequest request){
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found with this id " + request.getCustomerId()));
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setName(request.getName());
        beneficiary.setAccountNumber(request.getAccountNumber());
        beneficiary.setCustomer(customer);
        return beneficiaryRepository.save(beneficiary);
    }
    public List<Beneficiary> getAllBeneficiary(){
        return beneficiaryRepository.findAll();
    }
    public void deleteBeneficiary(Long id){
        if(!beneficiaryRepository.existsById(id)){
            throw new ResourceNotFoundException("Beneficiary not found with this id " + id);
        }
         beneficiaryRepository.deleteById(id);
    }
}
