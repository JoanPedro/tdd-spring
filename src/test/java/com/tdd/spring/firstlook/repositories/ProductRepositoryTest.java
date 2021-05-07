package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @Test
  @Transactional
  void testCreateAndFind() {
    Product product = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    productRepository.save(product);
    Optional<Product> result = productRepository.findById(1);
    assertTrue(result.isPresent());
  }

  @Test
  @Transactional
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
  @Transactional
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
  @Transactional
  void testCount() {
    Product product1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product product2 = new Product(null, "Table", "An great table", 3300.00);
    Product product3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(product1, product2, product3));
    long counter = productRepository.count();

    assertEquals(3, counter);
  }

  @Test
  @Transactional
  void testCustomListByName() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product p2 = new Product(null, "Table", "An great table", 3300.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByName = productRepository.findByName("Table");

    pByName.forEach(product -> {
      assertEquals("Table", product.getName());
    });
  }

  @Test
  @Transactional
  void testCustomListByNameAndDesc() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product p2 = new Product(null, "Table", "An great table", 3300.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByNameAndDesc = productRepository.findByNameAndDesc("Table", "An great table");

    pByNameAndDesc.forEach(product -> {
      assertEquals("Table", product.getName());
      assertEquals("An great table", product.getDesc());
    });
  }

  @Test
  @Transactional
  void testCustomListByDescLike() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product p2 = new Product(null, "Table", "An great table", 3300.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByDescLike = productRepository.findByDescLike("An");

    pByDescLike.forEach(product -> {
      if (product.getName().equals("Computer")) {
        assertEquals("An awesome Laptop", product.getDesc());
      } else {
        assertEquals("An great table", product.getDesc());
      }
    });
  }

  @Test
  @Transactional
  void testCustomListByDescContains() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3300.00);
    Product p2 = new Product(null, "Table", "An great table", 3300.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByDescLike = productRepository.findByDescContains("An");

    pByDescLike.forEach(product -> {
      if (product.getName().equals("Computer")) {
        assertEquals("An awesome Laptop", product.getDesc());
      } else {
        assertEquals("An great table", product.getDesc());
      }
    });
  }

  @Test
  @Transactional
  void testCustomListByPriceGreaterThan() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3000.00);
    Product p2 = new Product(null, "Table", "An great table", 2100.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByPrice = productRepository.findByPriceGreaterThan(2999.99);

    assertEquals(2, pByPrice.size());
  }

  @Test
  @Transactional
  void testCustomListByPriceBetween() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3000.00);
    Product p2 = new Product(null, "Table", "An great table", 2100.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByPrice = productRepository.findByPriceBetween(2999.99, 3400.00);

    assertEquals(2, pByPrice.size());
  }

  @Test
  @Transactional
  void testCustomListByIdsIn() {
    Product p1 = new Product(null, "Computer", "An awesome Laptop", 3000.00);
    Product p2 = new Product(null, "Table", "An great table", 2100.00);
    Product p3 = new Product(null, "Chair", "It's confortable", 3300.00);

    productRepository.saveAll(Arrays.asList(p1, p2, p3));

    List<Product> pByPrice = productRepository.findByIdIn(Arrays.asList(1, 2));

    assertEquals(2, pByPrice.size());
  }
}
