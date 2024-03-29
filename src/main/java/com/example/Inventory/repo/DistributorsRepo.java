package com.example.Inventory.repo;

import com.example.Inventory.models.Distributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepo extends JpaRepository<Distributors, Integer> {
}
