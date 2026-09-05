package com.example.bankingapi.controller;
import com.example.bankingapi.dto.CustomerRequest;
import com.example.bankingapi.entity.Customer;
import com.example.bankingapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
}
