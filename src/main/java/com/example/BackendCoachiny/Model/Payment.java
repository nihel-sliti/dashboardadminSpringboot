package com.example.BackendCoachiny.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code", length = 40, unique = true)
    private String code;
    @Column(name = "paymentMode", length = 30, nullable = false)
    private String paymentMode;
    @Column(name = "amount", nullable = false)
    private float amount;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "date", length = 50, nullable = true)
    private LocalDate date;
     @Column(name = "status", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}