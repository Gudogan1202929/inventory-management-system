package com.example.Inventory.controller;

import com.example.Inventory.models.Distributors;
import com.example.Inventory.servies.impl.DistributorsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributors")
public class DistributorsController {
    private final DistributorsServiceInterface distributorsServes;
    @Autowired
    public DistributorsController(DistributorsServiceInterface distributorsServices) {
        this.distributorsServes = distributorsServices;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> retriveDistributors() {
        try {
            return ResponseEntity.ok().body(distributorsServes.GetAllDistributors());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/retrive/{id}")
    public ResponseEntity<?> retriveDistributorsById(@PathVariable(required = true) int id) {
        try {
            return ResponseEntity.ok().body(distributorsServes.GetDistributor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDistributorsById(@PathVariable(required = true) int id) {
        try {
            distributorsServes.DeleteDistributor(id);
            return ResponseEntity.ok().body("Distributor deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDistributors(@RequestBody Distributors distributor) {
        try {
            distributorsServes.UpdateDistributor(distributor);
            return ResponseEntity.ok().body("Distributor updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDistributors(@RequestBody Distributors distributor) {
        try {
            distributorsServes.AddNewDistributor(distributor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Distributor added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}