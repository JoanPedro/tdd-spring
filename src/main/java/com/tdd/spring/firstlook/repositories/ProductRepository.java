package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findByName(String name);

  List<Product> findByNameAndDesc(String name, String desc);

  List<Product> findByDescLike(String desc);

  List<Product> findByDescContains(String desc);

  List<Product> findByPriceGreaterThan(Double price);

  List<Product> findByPriceBetween(Double price1, Double price2);

  List<Product> findByIdIn(List<Integer> ids);

  List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
}
