package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.many_to_many.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
}
