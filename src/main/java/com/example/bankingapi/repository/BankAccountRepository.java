package com.example.bankingapi.repository;
import com.example.bankingapi.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
