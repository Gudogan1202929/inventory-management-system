package com.example.Inventory.servies;

import com.example.Inventory.dto.DistributorsDto;
import com.example.Inventory.models.Distributors;
import com.example.Inventory.repo.DistributorsRepo;
import com.example.Inventory.servies.impl.DistributorsServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistributorsServes implements DistributorsServiceInterface {

    private final DistributorsRepo distributorsRepository;

    @Autowired
    public DistributorsServes(DistributorsRepo distributorsRepository) {
        this.distributorsRepository = distributorsRepository;
    }

    @Override
    @Transactional
    public void AddNewDistributor(Distributors distributors) throws RuntimeException{
        try {
            Distributors existingDistributors = distributorsRepository.findByNameAndEmail(distributors.getName(), distributors.getEmail());
            if (existingDistributors != null) {
                throw new IllegalStateException("Distributor with name " + distributors.getName() + " and email " + distributors.getEmail() + " already exists");
            }
            distributorsRepository.save(distributors);
        }
        catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new distributor", e);
        }
    }

    @Override
    @Transactional
    public void DeleteDistributor(int id) throws IllegalStateException{
        try {
            boolean exists = distributorsRepository.existsById(id);
            if (!exists) {
                throw new IllegalStateException("Distributor with id " + id + " does not exist");
            }
            distributorsRepository.deleteById(id);
        }catch (DataAccessException e){
            throw new IllegalStateException("Failed to delete distributor", e);
        }
    }

    @Override
    @Transactional
    public void UpdateDistributor(Distributors distributors) throws IllegalStateException{
        try {
            Distributors existingDistributors = distributorsRepository.findById(distributors.getId()).orElse(null);
            if (existingDistributors == null) {
                throw new IllegalStateException("Distributor with id " + distributors.getId() + " does not exist");
            }
            distributorsRepository.save(distributors);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Failed to update distributor", e);
        }
    }

    @Override
    @Transactional
    public DistributorsDto GetDistributor(int id) throws IllegalStateException{
        try {
            Distributors distributors = distributorsRepository.findById(id).orElse(null);
            if (distributors == null) {
                throw new IllegalStateException("Distributor with id " + id + " does not exist");
            }
            return new DistributorsDto(distributors.getId(),distributors.getName(), distributors.getAddress(),distributors.getPhone(),distributors.getEmail());
        }catch (DataAccessException e){
            throw new IllegalStateException("Failed to get distributor", e);
        }
    }

    @Override
    @Transactional
    public List<DistributorsDto> GetAllDistributors() throws RuntimeException {
        try {
            List<Distributors> distributorsList = distributorsRepository.findAll();
            if (distributorsList.isEmpty()) {
                throw new RuntimeException("No distributors found");
            }
            List<DistributorsDto> distributorsDtoList = new ArrayList<>();
            for (Distributors distributor : distributorsList) {
                DistributorsDto dto = new DistributorsDto();
                dto.setId(distributor.getId());
                dto.setName(distributor.getName());
                dto.setAddress(distributor.getAddress());
                dto.setPhone(distributor.getPhone());
                dto.setEmail(distributor.getEmail());
                distributorsDtoList.add(dto);
            }
            return distributorsDtoList;
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to get all distributors", e);
        }
    }
}
