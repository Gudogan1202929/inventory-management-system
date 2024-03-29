package com.example.Inventory.servies;

import com.example.Inventory.models.Distributors;
import com.example.Inventory.repo.DistributorsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorsServies {

    private final DistributorsRepo distributorsRepository;

    @Autowired
    public DistributorsServies(DistributorsRepo distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }

    @Transactional
    public void AddNewDistributor(Distributors distributors) throws RuntimeException{
        try {
            distributorsRepository.save(distributors);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new distributor", e);
        }
    }


    @Transactional
    public void DeleteDistributor(int id) throws IllegalStateException{
        boolean exists = distributorsRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Distributor with id " + id + " does not exist");
        }
        distributorsRepository.deleteById(id);
    }

    @Transactional
    public void UpdateDistributor(Distributors distributors) throws IllegalStateException{
        Distributors existingDistributors = distributorsRepository.findById(distributors.getId()).orElse(null);
        if (existingDistributors == null) {
            throw new IllegalStateException("Distributor with id " + distributors.getId() + " does not exist");
        }
        distributorsRepository.save(distributors);
    }

    @Transactional
    public Distributors GetDistributor(int id) throws IllegalStateException{
        Distributors distributors = distributorsRepository.findById(id).orElse(null);
        if (distributors == null) {
            throw new IllegalStateException("Distributor with id " + id + " does not exist");
        }
        return distributors;
    }

    @Transactional
    public List<Distributors> GetAllDistributors() throws RuntimeException{
        if (distributorsRepository.findAll().isEmpty()) {
            throw new RuntimeException("No distributors found");
        }
        return distributorsRepository.findAll();
    }
}
