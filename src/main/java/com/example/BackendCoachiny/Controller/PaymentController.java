package com.example.BackendCoachiny.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.BackendCoachiny.Model.Payment;
import com.example.BackendCoachiny.Model.Products;
import com.example.BackendCoachiny.Model.Status;
import com.example.BackendCoachiny.Services.PaymentService;

@RestController

public class PaymentController {
    @Autowired
    PaymentService paymentService;


 // Retrieve all products
   /* @GetMapping
    public ResponseEntity<Object> getAllPayments() {
        return new ResponseEntity<>(this.paymentService.getAllPayment(), HttpStatus.OK);
    } */
  @GetMapping("/payments")
 public ResponseEntity<List<Payment>> getAllPayments() {
    List<Payment> payment = this.paymentService.getAllPayment();
     return  new ResponseEntity<>(payment, HttpStatus.OK) ;
 }

 @PostMapping("/payments/changeStatus")
 public ResponseEntity<String> changePaymentStatus(@RequestParam("id") Long paymentId,
                                                   @RequestParam("status") String statusStr) {
     try {
         Status status = Status.valueOf(statusStr.toUpperCase());
         paymentService.updatePaymentStatus(paymentId, status);
         return ResponseEntity.ok("Payment status updated successfully!");  // Correct use of ResponseEntity
     } catch (IllegalArgumentException e) {
         return ResponseEntity.badRequest().body("Invalid status value");  // Correct use of ResponseEntity
     }
 }
 @GetMapping("/payments/search")
 public ResponseEntity<?> searchPayments(@RequestParam(value = "code", required = false) String code) {
     if (code != null && !code.isEmpty()) {
         try {
             Payment payment = paymentService.findByCode(code);
             return ResponseEntity.ok(payment); // Return the payment if found
         } catch (Exception e) {
             return ResponseEntity.badRequest().body("Payment not found for code: " + code);
         }
     } else {
         return ResponseEntity.badRequest().body("Code parameter is missing or empty");
     }
 }
}