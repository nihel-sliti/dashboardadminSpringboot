package com.example.BackendCoachiny.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendCoachiny.Model.Products;
import com.example.BackendCoachiny.Services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService =productsService;
    }

    @GetMapping()
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
      @PostMapping("/add")
    public ResponseEntity<Products> addProducts(@RequestBody Products product) {
        Products newProducts = productsService.addProducts(product);
        return new ResponseEntity<>(newProducts, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Products> updateEmployee(@RequestBody Products product) {
        Products updateEmployee = productsService.updateProducts(product);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable("id") Long id) {
        productsService.deleteProducts(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
