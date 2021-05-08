package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.one_to_one.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
