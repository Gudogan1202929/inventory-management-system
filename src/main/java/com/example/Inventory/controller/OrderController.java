package com.example.Inventory.controller;

import com.example.Inventory.models.Order;
import com.example.Inventory.servies.OrderServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServies orderServies;

    @Autowired
    public OrderController(OrderServies orderServies) {
        this.orderServies = orderServies;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> RetriveOrder() {
        try {
            return ResponseEntity.ok().body(orderServies.GetAllOrder());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @GetMapping("/retrive/{orderId}")
    public ResponseEntity<?> RetriveOrder(int id) {
        try {
            return ResponseEntity.ok().body(orderServies.GetOrder(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> UpdateOrder(@RequestBody Order order) {
        try {
            orderServies.UpdateOrder(order);
            return ResponseEntity.ok().body("Order Updated Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> DeleteOrder(@PathVariable int orderId) {
        try {
            orderServies.DeleteOrder(orderId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddOrder(@RequestBody Order order) {
        try {
            orderServies.AddNewOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order Added Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }


    @PutMapping("/{orderId}/for/distributor/{distributorId}")
    public ResponseEntity<?> AddDistributorToOrder(@PathVariable int orderId, @PathVariable int distributorId) {
        try {
            orderServies.setDistributorInOrder(orderId, distributorId);
            return ResponseEntity.ok().body("Distributor added to order successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }
}
