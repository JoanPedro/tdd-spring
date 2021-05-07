package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  void testCreateAndFind() {
    Employee employee = new Employee(null, "Joan Pedro");
    employeeRepository.save(employee);
    Optional<Employee> result = employeeRepository.findById(1L);
    assertTrue(result.isPresent());
  }

  @Test
  void testUpdateAndFind() {
    Employee employee = new Employee(null, "Joan Pedro");
    employeeRepository.save(employee);

    Employee result = employeeRepository.findById(1L).get();
    result.setName("New Computed");

    employeeRepository.save(result);

    Employee result2 = employeeRepository.findById(1L).get();
    assertEquals("New Computed", result2.getName());
  }

  @Test
  void testDeleteAndFind() {
    Employee employee = new Employee(null, "Joan Pedro");
    employeeRepository.save(employee);

    Optional<Employee> result = employeeRepository.findById(1L);

    employeeRepository.deleteById(1L);

    Optional<Employee> result2 = employeeRepository.findById(1L);
    assertTrue(result.isPresent());
    assertFalse(result2.isPresent());
  }

  @Test
  void testCount() {
    Employee employee1 = new Employee(null, "Joan Pedro");
    Employee employee2 = new Employee(null, "Oliveira");
    Employee employee3 = new Employee(null, "Souza");

    employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));
    long counter = employeeRepository.count();

    assertEquals(3, counter);
  }
}
