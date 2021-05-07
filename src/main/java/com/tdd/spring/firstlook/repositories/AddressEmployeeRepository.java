package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.AddressEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressEmployeeRepository extends JpaRepository<AddressEmployee, Long> {
}
