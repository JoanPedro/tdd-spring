package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.many_to_many.Programmer;
import com.tdd.spring.firstlook.domain.many_to_many.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProgrammerRepositoryTest {

  @Autowired
  ProgrammerRepository programmerRepository;

  @Test
  @Transactional
  void TestOne() {
    Programmer p1 = new Programmer(null, "Joan Pedro", 8800.00);
    Programmer p2 = new Programmer(null, "Bill Gates", 28800.00);
    Programmer p3 = new Programmer(null, "John Lenon", 18800.00);

    Project pj1 = new Project(null, "E-commerce");
    Project pj2 = new Project(null, "The Mobile");
    Project pj3 = new Project(null, "Faxating");

    p1.addProjects(Arrays.asList(pj1, pj2));
    p2.addProjects(Arrays.asList(pj2, pj3));
    p3.addProjects(Arrays.asList(pj3, pj1));

    programmerRepository.saveAll(Arrays.asList(p1, p2, p3));

    Programmer rP1 = programmerRepository.findById(1L).get();
    Programmer rP2 = programmerRepository.findById(2L).get();
    Programmer rP3 = programmerRepository.findById(3L).get();

    Assertions.assertFalse(rP1.getProjects().isEmpty());
    Assertions.assertFalse(rP2.getProjects().isEmpty());
    Assertions.assertFalse(rP3.getProjects().isEmpty());
  }
}
