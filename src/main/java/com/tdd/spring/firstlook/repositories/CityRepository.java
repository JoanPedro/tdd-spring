package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
