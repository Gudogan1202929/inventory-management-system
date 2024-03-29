package com.example.Inventory.controller;

import com.example.Inventory.models.Order;
import com.example.Inventory.servies.OrderServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {


    private final OrderServies orderServies;

    @Autowired
    public OrderController(OrderServies orderServies) {
        this.orderServies = orderServies;
    }

    @GetMapping("/order/retrive")
    public ResponseEntity<?> RetriveOrder() {
        try {
            return ResponseEntity.ok().body(orderServies.GetAllOrder());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @GetMapping("/order/retrive/{id}")
    public ResponseEntity<?> RetriveOrder(int id) {
        try {
            return ResponseEntity.ok().body(orderServies.GetOrder(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PutMapping("/order/update")
    public ResponseEntity<?> UpdateOrder(@RequestBody Order order) {
        try {
            orderServies.UpdateOrder(order);
            return ResponseEntity.ok().body("Order Updated Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<?> DeleteOrder(int id) {
        try {
            orderServies.DeleteOrder(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }

    @PostMapping("/order/add")
    public ResponseEntity<?> AddOrder(@RequestBody Order order) {
        try {
            orderServies.AddNewOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order Added Successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
}
