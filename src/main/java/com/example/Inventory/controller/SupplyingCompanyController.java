package com.example.Inventory.controller;

import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.servies.SupplyingCompanyServies;
import com.example.Inventory.servies.impl.SpplyingCompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplying/company")
public class SupplyingCompanyController {
    private final SpplyingCompanyServiceInterface supplyingCompanyServices;
    @Autowired
    public SupplyingCompanyController(SpplyingCompanyServiceInterface supplyingCompanyServes) {
        this.supplyingCompanyServices = supplyingCompanyServes;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> getSupplyingCompany() {
        try {
            return ResponseEntity.ok().body(supplyingCompanyServices.GetAllSupplyingCompany());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @GetMapping("/retrive/{id}")
    public ResponseEntity<?> getSupplyingCompanyById(@PathVariable (required = true) int id) {
        try {
            return ResponseEntity.ok().body(supplyingCompanyServices.GetSupplyingCompany(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSupplyingCompany(@RequestBody SupplyingCompany supplyingCompany) {
        try {
            supplyingCompanyServices.UpdateSupplyingCompany(supplyingCompany);
            return ResponseEntity.ok().body("Supplying Company Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupplyingCompany(@PathVariable (required = true) int id) {
        try {
            supplyingCompanyServices.DeleteSupplyingCompany(id);
            return ResponseEntity.ok().body("Supplying Company Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSupplyingCompany(@RequestBody SupplyingCompany supplyingCompany) {
        try {
            supplyingCompanyServices.AddNewSupplyingCompany(supplyingCompany);
            return ResponseEntity.status(HttpStatus.CREATED).body("Supplying Company Added Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error :"+e.getMessage());
        }
    }
}