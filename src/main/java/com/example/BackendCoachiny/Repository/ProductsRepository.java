package com.example.BackendCoachiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackendCoachiny.Model.Products;

public interface ProductsRepository  extends JpaRepository<Products, Long> {
    void deleteProductsById(Long id);
}
