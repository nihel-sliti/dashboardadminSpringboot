package com.example.BackendCoachiny.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendCoachiny.Model.Payment;
import com.example.BackendCoachiny.Repository.PaymentRepository;

import ch.qos.logback.core.status.Status;
import jakarta.transaction.Transactional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Transactional
    public Payment updatePaymentStatus(Long paymentId, com.example.BackendCoachiny.Model.Status status) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment ID: " + paymentId));
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public Payment findByCode(String code) {
        return paymentRepository.findByCode(code);
    }
}

