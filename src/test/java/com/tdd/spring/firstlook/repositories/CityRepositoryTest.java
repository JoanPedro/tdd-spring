package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CityRepositoryTest {

  @Autowired
  CityRepository cityRepository;

  @Test
  void testSaveAndFindAll() {
    City city = new City(null, "New York");
    cityRepository.save(city);

    List<City> cityList = cityRepository.findAll();

    cityList.forEach(_city -> {
      System.out.println("ID: " + _city.getId() + " NAME: " + _city.getName());
    });

    System.out.println(cityList.isEmpty());
    assertEquals(1, cityList.size());
  }
}
