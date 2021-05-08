package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.payment_inheritance.CheckBolt;
import com.tdd.spring.firstlook.domain.payment_inheritance.CreditCard;
import com.tdd.spring.firstlook.domain.payment_inheritance.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class PaymentRepositoryTest {

  @Autowired
  PaymentRepository paymentRepository;

  @BeforeEach
  void setup() {
    List<Payment> payments = paymentRepository.findAll();
    if (payments.isEmpty()) {
      CreditCard cc = new CreditCard(null, 10000.00, "1234567890");
      CheckBolt ch = new CheckBolt(null, 20000.00, "0987654321");
      paymentRepository.saveAll(Arrays.asList(cc, ch));
    }
  }

  @Test
  void Tests() {
    Payment ccResult = paymentRepository.findById(1L).get();
    assertNotNull(ccResult);
    System.out.println(ccResult);
  }
}
