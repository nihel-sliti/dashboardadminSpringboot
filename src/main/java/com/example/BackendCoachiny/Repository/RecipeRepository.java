package com.example.BackendCoachiny.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendCoachiny.Model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByPeriod(String period);
}
