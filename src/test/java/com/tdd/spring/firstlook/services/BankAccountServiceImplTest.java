package com.tdd.spring.firstlook.services;

import com.tdd.spring.firstlook.domain.transaction.BankAccount;
import com.tdd.spring.firstlook.repositories.BankAccountRepository;
import com.tdd.spring.firstlook.services.abstracts.BankAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BankAccountServiceImplTest {

  @Autowired
  BankAccountService bankAccountService;

  @Autowired
  BankAccountRepository bankAccountRepository;

  @Test
  void TransferTest() {
    bankAccountService.transfer(1000.00);

    BankAccount rBa1 = bankAccountRepository.findById(1L).get();
    BankAccount rBa2 = bankAccountRepository.findById(2L).get();

    Assertions.assertEquals(49000.00, rBa1.getBalance());
    Assertions.assertEquals(56000.00, rBa2.getBalance());
  }

  @Test
  void TransferExceptionallyTest() {
    bankAccountService.populate();

    Assertions.assertThrows(RuntimeException.class, () -> bankAccountService.transferWithException(1000.00));

    BankAccount rBa1 = bankAccountRepository.findById(1L).get();
    BankAccount rBa2 = bankAccountRepository.findById(2L).get();

    Assertions.assertEquals(50000.00, rBa1.getBalance());
    Assertions.assertEquals(55000.00, rBa2.getBalance());
  }

}
