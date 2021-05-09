package com.tdd.spring.firstlook.services.abstracts;

public interface BankAccountService {
  void transfer(Double amount);
  void populate();
  void transferWithException(Double amount);
}
