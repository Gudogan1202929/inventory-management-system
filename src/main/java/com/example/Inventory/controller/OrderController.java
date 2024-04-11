package com.example.Inventory.controller;

import com.example.Inventory.models.Order;
import com.example.Inventory.servies.OrderServies;
import com.example.Inventory.servies.impl.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceInterface orderServices;
    @Autowired
    public OrderController(OrderServiceInterface orderServes) {
        this.orderServices = orderServes;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> RetriveOrder() {
        try {
            return ResponseEntity.ok().body(orderServices.GetAllOrder());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @GetMapping("/retrive/{orderId}")
    public ResponseEntity<?> RetriveOrder(@PathVariable int orderId) {
        try {
            return ResponseEntity.ok().body(orderServices.GetOrder(orderId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> UpdateOrder(@RequestBody Order order) {
        try {
            orderServices.UpdateOrder(order);
            return ResponseEntity.ok().body("Order Updated Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> DeleteOrder(@PathVariable int orderId) {
        try {
            orderServices.DeleteOrder(orderId);
            return ResponseEntity.ok().body("Order Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddOrder(@RequestBody Order order) {
        try {
            orderServices.AddNewOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order Added Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PutMapping("/{orderId}/for/distributor/{distributorId}")
    public ResponseEntity<?> AddDistributorToOrder(@PathVariable int orderId, @PathVariable int distributorId) {
        try {
            orderServices.setDistributorInOrder(orderId, distributorId);
            return ResponseEntity.ok().body("Distributor added to order successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }
}