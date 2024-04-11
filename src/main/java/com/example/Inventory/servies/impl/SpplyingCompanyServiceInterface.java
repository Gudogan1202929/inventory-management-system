package com.example.Inventory.servies.impl;

import com.example.Inventory.models.SupplyingCompany;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface SpplyingCompanyServiceInterface {

    void AddNewSupplyingCompany(SupplyingCompany supplyingCompany) throws RuntimeException;

    void DeleteSupplyingCompany(int id) throws IllegalStateException;

    void UpdateSupplyingCompany(SupplyingCompany supplyingCompany) throws IllegalStateException;

    SupplyingCompany GetSupplyingCompany(int id) throws IllegalStateException;

    List<SupplyingCompany> GetAllSupplyingCompany() throws RuntimeException;
}
