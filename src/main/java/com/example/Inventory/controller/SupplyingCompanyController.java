package com.example.Inventory.controller;

import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.servies.SupplyingCompanyServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplyingCompanyController {

    private final SupplyingCompanyServies supplyingCompanyServies;

    @Autowired
    public SupplyingCompanyController(SupplyingCompanyServies supplyingCompanyServies) {
        this.supplyingCompanyServies = supplyingCompanyServies;
    }

    @GetMapping("/retrive/supplying/company")
    public ResponseEntity<?> getSupplyingCompany() {
        try {
            return ResponseEntity.ok().body(supplyingCompanyServies.GetAllSupplyingCompany());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @GetMapping("/retrive/supplying/company/{id}")
    public ResponseEntity<?> getSupplyingCompanyById(@PathVariable (required = true) int id) {
        try {
            return ResponseEntity.ok().body(supplyingCompanyServies.GetSupplyingCompany(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @PutMapping("/update/supplying/company")
    public ResponseEntity<?> updateSupplyingCompany(@RequestBody SupplyingCompany supplyingCompany) {
        try {
            supplyingCompanyServies.UpdateSupplyingCompany(supplyingCompany);
            return ResponseEntity.ok().body("Supplying Company Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @DeleteMapping("/delete/supplying/company/{id}")
    public ResponseEntity<?> deleteSupplyingCompany(@PathVariable (required = true) int id) {
        try {
            supplyingCompanyServies.DeleteSupplyingCompany(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplying Company Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @PostMapping("/add/supplying/company")
    public ResponseEntity<?> addSupplyingCompany(@RequestBody SupplyingCompany supplyingCompany) {
        try {
            supplyingCompanyServies.AddNewSupplyingCompany(supplyingCompany);
            return ResponseEntity.status(HttpStatus.CREATED).body("Supplying Company Added Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }
}
