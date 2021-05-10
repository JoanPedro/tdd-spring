package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.steps.Order2Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order2ItemRepository extends JpaRepository<Order2Item, Long> {
}
