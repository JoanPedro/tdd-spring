package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.files.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images, Long> {
}
