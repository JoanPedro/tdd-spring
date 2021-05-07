package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.payment.Check;
import com.tdd.spring.firstlook.domain.payment.CreditCard;
import com.tdd.spring.firstlook.domain.payment.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class PaymentRepositoryTest {

  @Autowired
  PaymentRepository paymentRepository;

  @BeforeEach
  void setup() {
    List<Payment> payments = paymentRepository.findAll();
    if (payments.isEmpty()) {
      CreditCard cc = new CreditCard("1234567890");
      Check ch = new Check("0987654321");
      paymentRepository.saveAll(Arrays.asList(cc, ch));
    }
  }

  @Test
  void Tests() {
    Payment ccResult = paymentRepository.findById(1L).get();
    System.out.println(ccResult);
  }
}
