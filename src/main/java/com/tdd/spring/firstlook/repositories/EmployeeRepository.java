package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
