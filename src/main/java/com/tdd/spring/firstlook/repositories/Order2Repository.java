package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.steps.Order2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order2Repository extends JpaRepository<Order2, Long> {
}
