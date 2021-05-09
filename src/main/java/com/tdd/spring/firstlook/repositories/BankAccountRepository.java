package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.transaction.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
