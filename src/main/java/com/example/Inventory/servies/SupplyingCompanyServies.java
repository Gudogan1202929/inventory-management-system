package com.example.Inventory.servies;

import com.example.Inventory.models.Order;
import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.repo.SupplyingCompanyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyingCompanyServies {

    private final SupplyingCompanyRepo supplyingCompanyRepo;

    @Autowired
    public SupplyingCompanyServies(SupplyingCompanyRepo supplyingCompanyRepo) {
        this.supplyingCompanyRepo = supplyingCompanyRepo;
    }


    @Transactional
    public void AddNewSupplyingCompany(SupplyingCompany supplyingCompany) throws RuntimeException{
        try {
            supplyingCompanyRepo.save(supplyingCompany);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new supplying Company", e);
        }
    }


    @Transactional
    public void DeleteSupplyingCompany(int id) throws IllegalStateException{
        boolean exists = supplyingCompanyRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("supplying Company with id " + id + " does not exist");
        }
        supplyingCompanyRepo.deleteById(id);
    }

    @Transactional
    public void UpdateSupplyingCompany(SupplyingCompany supplyingCompany) throws IllegalStateException{
        SupplyingCompany supplyingCompanyFound = supplyingCompanyRepo.findById(supplyingCompany.getId()).orElse(null);
        if (supplyingCompanyFound == null) {
            throw new IllegalStateException("supplying Company with id " + supplyingCompany.getId() + " does not exist");
        }
        supplyingCompanyRepo.save(supplyingCompany);
    }

    @Transactional
    public SupplyingCompany GetSupplyingCompany(int id) throws IllegalStateException{
        SupplyingCompany supplyingCompany = supplyingCompanyRepo.findById(id).orElse(null);
        if (supplyingCompany == null) {
            throw new IllegalStateException("supplying Company with id " + id + " does not exist");
        }
        return supplyingCompany;
    }

    @Transactional
    public List<SupplyingCompany> GetAllSupplyingCompany() throws RuntimeException{
        if (supplyingCompanyRepo.findAll().isEmpty()) {
            throw new RuntimeException("No supplying Company found");
        }
        return supplyingCompanyRepo.findAll();
    }
}
