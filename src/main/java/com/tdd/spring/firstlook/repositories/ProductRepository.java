package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
