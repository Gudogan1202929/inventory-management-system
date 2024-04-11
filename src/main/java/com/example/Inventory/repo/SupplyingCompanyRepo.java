package com.example.Inventory.repo;

import com.example.Inventory.dto.SupplyingCompanyDto;
import com.example.Inventory.models.SupplyingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyingCompanyRepo extends JpaRepository<SupplyingCompany, Integer> {
    SupplyingCompany findByCompanyName(String companyName);
}
