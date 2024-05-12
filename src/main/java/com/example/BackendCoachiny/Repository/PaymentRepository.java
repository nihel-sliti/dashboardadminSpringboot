package com.example.BackendCoachiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BackendCoachiny.Model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{
    Payment findByCode(String code);
}