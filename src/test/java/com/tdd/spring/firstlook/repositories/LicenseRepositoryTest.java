package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.one_to_one.License;
import com.tdd.spring.firstlook.domain.one_to_one.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LicenseRepositoryTest {
  @Autowired
  LicenseRepository licenseRepository;

  @Test
  void TestOne() {
    License l1 = new License(null, "Software", new Date(), new Date());
    Person p1 = new Person(null, "Joan Pedro", "Oliveira de Souza", 23);
    l1.addPerson(p1);

    licenseRepository.save(l1);

    License rL1 = licenseRepository.findById(1L).get();

    Assertions.assertEquals(23, rL1.getPerson().getAge());
  }
}
