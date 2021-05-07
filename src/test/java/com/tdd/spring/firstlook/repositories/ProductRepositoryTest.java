package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @Test
  void testCreateAndFind() {
    Product product = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    productRepository.save(product);
    Optional<Product> result = productRepository.findById(1);
    assertTrue(result.isPresent());
  }

  @Test
  void testUpdateAndFind() {
    Product product = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    productRepository.save(product);

    Product result = productRepository.findById(1).get();
    result.setId(1);
    result.setName("New Computed");

    productRepository.save(result);

    Product result2 = productRepository.findById(1).get();
    assertEquals("New Computed", result2.getName());
  }

  @Test
  void testDeleteAndFind() {
    Product product = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    productRepository.save(product);

    Optional<Product> result = productRepository.findById(1);

    productRepository.deleteById(1);

    Optional<Product> result2 = productRepository.findById(1);
    assertTrue(result.isPresent());
    assertFalse(result2.isPresent());
  }

  @Test
  void testCount() {
    Product product1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product product2 = new Product(null, "Table", "An great table", 3300.00);
    Product product3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(product1, product2, product3));
    long counter = productRepository.count();

    assertEquals(3, counter);
  }
}
