package com.example.Inventory.servies;

import com.example.Inventory.dto.SupplyingCompanyDto;
import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;
import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.repo.ItemsOrderRepo;
import com.example.Inventory.repo.SupplyingCompanyRepo;
import com.example.Inventory.servies.impl.ItemServiceInterface;
import com.example.Inventory.servies.impl.SpplyingCompanyServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class SupplyingCompanyServies implements SpplyingCompanyServiceInterface {

    private final SupplyingCompanyRepo supplyingCompanyRepo;

    @Autowired
    public SupplyingCompanyServies(SupplyingCompanyRepo supplyingCompanyRepo) {
        this.supplyingCompanyRepo = supplyingCompanyRepo;
    }

    @Override
    @Transactional
    public void AddNewSupplyingCompany(SupplyingCompany supplyingCompany) throws RuntimeException {
        try {
            SupplyingCompany supplyingCompanyFound = supplyingCompanyRepo.findByCompanyName(supplyingCompany.getCompanyName());
            if (supplyingCompanyFound != null) {
                throw new IllegalStateException("Supplying company with name " + supplyingCompany.getCompanyName() + " already exists");
            }
            supplyingCompanyRepo.save(supplyingCompany);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }


    @Override
    @Transactional
    public void DeleteSupplyingCompany(int id) throws IllegalStateException{
        try {
            boolean exists = supplyingCompanyRepo.existsById(id);
            if (!exists) {
                throw new IllegalStateException("supplying Company with id " + id + " does not exist");
            }
            supplyingCompanyRepo.deleteById(id);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void UpdateSupplyingCompany(SupplyingCompany supplyingCompany) throws IllegalStateException{
        try {
            SupplyingCompany supplyingCompanyFound = supplyingCompanyRepo.findById(supplyingCompany.getId()).orElse(null);
            if (supplyingCompanyFound == null) {
                throw new IllegalStateException("supplying Company with id " + supplyingCompany.getId() + " does not exist");
            }
            supplyingCompanyRepo.save(supplyingCompany);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public SupplyingCompanyDto GetSupplyingCompany(int id) throws IllegalStateException{
        try {
            SupplyingCompany supplyingCompany = supplyingCompanyRepo.findById(id).orElse(null);
            if (supplyingCompany == null) {
                throw new IllegalStateException("supplying Company with id " + id + " does not exist");
            }
            return new SupplyingCompanyDto(supplyingCompany.getId(),supplyingCompany.getCompanyName(),
                    supplyingCompany.getPhoneNumber(),supplyingCompany.getLocation(),supplyingCompany.getEmail(),
                    supplyingCompany.getItems());
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<SupplyingCompanyDto> GetAllSupplyingCompany() throws RuntimeException {
        try {
            List<SupplyingCompany> supplyingCompanyList = supplyingCompanyRepo.findAll();
            if (supplyingCompanyList.isEmpty()) {
                throw new RuntimeException("No supplying Company found");
            }

            List<SupplyingCompanyDto> supplyingCompanyDtoList = new LinkedList<>();
            for (SupplyingCompany supplyingCompany : supplyingCompanyList) {
                SupplyingCompanyDto dto = new SupplyingCompanyDto();
                dto.setId(supplyingCompany.getId());
                dto.setCompanyName(supplyingCompany.getCompanyName());
                dto.setPhoneNumber(supplyingCompany.getPhoneNumber());
                dto.setLocation(supplyingCompany.getLocation());
                dto.setEmail(supplyingCompany.getEmail());
                dto.setItems(supplyingCompany.getItems());
                supplyingCompanyDtoList.add(dto);
            }
            return supplyingCompanyDtoList;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }
}