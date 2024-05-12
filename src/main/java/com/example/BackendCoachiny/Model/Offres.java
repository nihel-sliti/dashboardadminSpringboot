package com.example.BackendCoachiny.Model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offreId;
    private String nom;
    private float prix;
    private String description;
    private String programme;
    /*@OneToMany(mappedBy = "offre")
    private Set<Service> services;
    @OneToMany(mappedBy = "offre")
    private Set<Bonus> bonuses;
*/
    // Getters et setters

}