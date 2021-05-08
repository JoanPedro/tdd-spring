package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Customer;
import com.tdd.spring.firstlook.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  @Transactional
  void testOne() {
    Customer c1 = new Customer(null, "Joan Pedro Oliveira de Souza");
    PhoneNumber p1 = new PhoneNumber(null, "1234567890", "Cellphone");
    PhoneNumber p2 = new PhoneNumber(null, "0987654321", "Fixed Phone");

    c1.addPhoneNumbers(Arrays.asList(p1, p2));
    customerRepository.save(c1);

    Customer rCustomer = customerRepository.findById(1L).get();
    assertEquals("Joan Pedro Oliveira de Souza", rCustomer.getName());
    assertEquals(2, rCustomer.getPhoneNumbers().size());
    rCustomer.getPhoneNumbers().forEach(_phoneNumber -> assertEquals(1L, _phoneNumber.getCustomer().getId()));
  }

  @Test
  @Transactional
  void TestLoadCustomer() {
    Customer c2 = new Customer(null, "Bill Gates");
    PhoneNumber p11 = new PhoneNumber(null, "1234567890", "Cellphone");
    PhoneNumber p12 = new PhoneNumber(null, "0987654321", "Fixed Phone");
    PhoneNumber p13 = new PhoneNumber(null, "0113321032", "Fax");
    c2.addPhoneNumbers(Arrays.asList(p11, p12, p13));

    customerRepository.save(c2);
    Customer rCustomer = customerRepository.findById(1L).get();

    assertEquals("Bill Gates", rCustomer.getName());
    assertEquals(3, rCustomer.getPhoneNumbers().size());
    rCustomer.getPhoneNumbers().forEach(_phoneNumber -> assertEquals(1L, _phoneNumber.getCustomer().getId()));
  }

  @Test
  @Transactional
  void TestUpdateCustomer() {
    Customer c3 = new Customer(null, "Bill Gates");
    PhoneNumber p11 = new PhoneNumber(null, "1234567890", "Cellphone");
    PhoneNumber p12 = new PhoneNumber(null, "0987654321", "Fixed Phone");
    PhoneNumber p13 = new PhoneNumber(null, "0113321032", "Fax");
    c3.addPhoneNumbers(Arrays.asList(p11, p12, p13));

    customerRepository.save(c3);

    Customer rCustomer = customerRepository.findById(1L).get();
    rCustomer.setName("John Bush");
    rCustomer.getPhoneNumbers().forEach(p -> p.setType("Cellphone"));

    customerRepository.save(c3);

    Customer rCustomer2 = customerRepository.findById(1L).get();

    assertEquals("John Bush", rCustomer2.getName());
    assertEquals(3, rCustomer2.getPhoneNumbers().size());
    rCustomer2.getPhoneNumbers().forEach(_phoneNumber -> assertEquals(1L, _phoneNumber.getCustomer().getId()));
    rCustomer2.getPhoneNumbers().forEach(_phoneNumber -> assertEquals("Cellphone", _phoneNumber.getType()));
  }

  @Test
  @Transactional
  void TestDeleteCustomer() {
    Customer c2 = new Customer(null, "Bill Gates");
    PhoneNumber p11 = new PhoneNumber(null, "1234567890", "Cellphone");
    PhoneNumber p12 = new PhoneNumber(null, "0987654321", "Fixed Phone");
    PhoneNumber p13 = new PhoneNumber(null, "0113321032", "Fax");
    c2.addPhoneNumbers(Arrays.asList(p11, p12, p13));

    customerRepository.save(c2);
    Customer rCustomer = customerRepository.findById(1L).get();
    assertNotNull(rCustomer);

    customerRepository.deleteById(1L);
    Optional<Customer> rCustomer2 = customerRepository.findById(1L);
    assertTrue(rCustomer2.isEmpty());
  }
}
