package com.example.BackendCoachiny.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programmeId;
    private String description;
   /*  @ManyToOne
    @JoinColumn(name = "offreId", nullable = false)
    private Offres offre;

    // Getters et setters*/
}