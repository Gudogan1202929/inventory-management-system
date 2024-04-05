package com.example.Inventory.controller;

import com.example.Inventory.models.Distributors;
import com.example.Inventory.servies.DistributorsServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributors")
public class DistributorsController {

    private final DistributorsServies distributorsServies;

    @Autowired
    public DistributorsController(DistributorsServies distributorsServies) {
        this.distributorsServies = distributorsServies;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> retriveDistributors() {
        try {
            return ResponseEntity.ok().body(distributorsServies.GetAllDistributors());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/retrive/{id}")
    public ResponseEntity<?> retriveDistributorsById(@PathVariable(required = true) int id) {
        try {
            return ResponseEntity.ok().body(distributorsServies.GetDistributor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDistributorsById(@PathVariable(required = true) int id) {
        try {
            distributorsServies.DeleteDistributor(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Distributor with id " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDistributors(@RequestBody Distributors distributor) {
        try {
            distributorsServies.UpdateDistributor(distributor);
            return ResponseEntity.ok().body("Distributor updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDistributors(@RequestBody Distributors distributor) {
        try {
            System.out.println(distributor.toString());
            distributorsServies.AddNewDistributor(distributor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Distributor added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


}
