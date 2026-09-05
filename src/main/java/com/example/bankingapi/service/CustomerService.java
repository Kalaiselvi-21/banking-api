package com.example.bankingapi.service;
import com.example.bankingapi.dto.CustomerRequest;
import com.example.bankingapi.entity.Customer;
import com.example.bankingapi.exception.ResourceNotFoundException;
import com.example.bankingapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public Customer createCustomer(CustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
       return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with this id " + id));
    }
}
