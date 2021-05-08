package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Customer;
import com.tdd.spring.firstlook.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  @Transactional
  void testOne() {
    Customer c = new Customer(null, "Joan Pedro Oliveira de Souza");
    PhoneNumber p1 = new PhoneNumber(null, "1234567890", "Cellphone");
    PhoneNumber p2 = new PhoneNumber(null, "0987654321", "Fixed Phone");
    c.addPhoneNumbers(Arrays.asList(p1, p2));

    customerRepository.save(c);

    Customer rCustomer = customerRepository.findById(1L).get();

    rCustomer.getPhoneNumbers().forEach(p -> System.out.println(p.getNumber()));

    assertEquals("Joan Pedro Oliveira de Souza", rCustomer.getName());
    assertEquals(2, rCustomer.getPhoneNumbers().size());

    rCustomer.getPhoneNumbers().forEach(_phoneNumber -> assertEquals(1L, _phoneNumber.getCustomer().getId()));
  }
}
