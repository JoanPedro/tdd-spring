package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.payment_inheritance.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
