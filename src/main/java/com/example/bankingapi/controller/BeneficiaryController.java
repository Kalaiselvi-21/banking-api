package com.example.bankingapi.controller;

import com.example.bankingapi.dto.BeneficiaryRequest;
import com.example.bankingapi.entity.Beneficiary;
import com.example.bankingapi.service.BeneficiaryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {
    private final BeneficiaryService beneficiaryService;
    public BeneficiaryController(BeneficiaryService beneficiaryService){
        this.beneficiaryService = beneficiaryService;
    }
    @PostMapping
    public Beneficiary createBeneficiary(@Valid @RequestBody BeneficiaryRequest request){
        return beneficiaryService.createBeneficiary(request);
    }
    @GetMapping
    public List<Beneficiary> getAllBeneficiaries(){
        return beneficiaryService.getAllBeneficiary();
    }
    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Long id){
        beneficiaryService.deleteBeneficiary(id);
    }
}
