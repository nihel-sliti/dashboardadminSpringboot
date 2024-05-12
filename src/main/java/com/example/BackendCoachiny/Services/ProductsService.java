package com.example.BackendCoachiny.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendCoachiny.Model.Products;
import com.example.BackendCoachiny.Repository.ProductsRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductsService {
private final ProductsRepository productsRepo;
@Autowired
public ProductsService(ProductsRepository productsRepo){
    this.productsRepo = productsRepo;
}

 
public Products addProducts( Products product) {
       
    return  productsRepo.save(product);
}

public List<Products> findAllProducts() {
    return  productsRepo.findAll();
}

public  Products updateProducts( Products product) {
    return  productsRepo.save(product);
}


@Transactional // Add this annotation
public void deleteProducts(Long id){
    productsRepo.deleteProductsById(id);
}

}
