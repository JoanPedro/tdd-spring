package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.one_to_many.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
