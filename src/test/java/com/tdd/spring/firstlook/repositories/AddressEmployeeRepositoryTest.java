package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Address;
import com.tdd.spring.firstlook.domain.AddressEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class AddressEmployeeRepositoryTest {

  @Autowired
  AddressEmployeeRepository addressEmployeeRepository;

  @Test
  void testCreateEmbeddable() {
    Address address = new Address("Rua das Pedrinhas", "Salvador", "Bahia", "400000", "Brazil");
    AddressEmployee addressEmployee = new AddressEmployee(null, "Joan Pedro", address);
    addressEmployeeRepository.save(addressEmployee);

    AddressEmployee aEmp = addressEmployeeRepository.findById(1L).get();
    assertEquals("Rua das Pedrinhas", aEmp.getAddress().getStreetAddress());
  }
}
