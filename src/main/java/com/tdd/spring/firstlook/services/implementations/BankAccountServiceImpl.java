package com.tdd.spring.firstlook.services.implementations;

import com.tdd.spring.firstlook.domain.transaction.BankAccount;
import com.tdd.spring.firstlook.repositories.BankAccountRepository;
import com.tdd.spring.firstlook.services.abstracts.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class BankAccountServiceImpl implements BankAccountService {

  @Autowired
  BankAccountRepository bankAccountRepository;

  @Override
  @Transactional
  public void populate() {
    BankAccount ba1 = new BankAccount(null, "Obama", "Barack", 50000.00);
    BankAccount ba2 = new BankAccount(null, "Donald", "Trump", 55000.00);
    bankAccountRepository.saveAll(Arrays.asList(ba1, ba2));
  }

  @Override
  @Transactional
  public void transfer(Double amount) {
    populate();

    BankAccount rObama = bankAccountRepository.findById(1L).get();
    BankAccount rTrump = bankAccountRepository.findById(2L).get();

    rObama.setBalance(rObama.getBalance() - amount);
    bankAccountRepository.save(rObama);

    rTrump.setBalance(rTrump.getBalance() + amount);
    bankAccountRepository.save(rTrump);
  }

  @Override
  @Transactional
  public void transferWithException(Double amount) {
    BankAccount rObama = bankAccountRepository.findById(1L).get();
    BankAccount rTrump = bankAccountRepository.findById(2L).get();

    rObama.setBalance(rObama.getBalance() - amount);
    bankAccountRepository.save(rObama);

    if (true)
      throw new RuntimeException();

    rTrump.setBalance(rTrump.getBalance() + amount);
    bankAccountRepository.save(rTrump);
  }
}
