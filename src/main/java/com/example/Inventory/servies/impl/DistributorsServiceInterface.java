package com.example.Inventory.servies.impl;

import com.example.Inventory.dto.DistributorsDto;
import com.example.Inventory.models.Distributors;

import java.util.List;

public interface DistributorsServiceInterface {


    void AddNewDistributor(Distributors distributors) throws RuntimeException;

    void DeleteDistributor(int id) throws IllegalStateException;

    void UpdateDistributor(Distributors distributors) throws IllegalStateException;

    DistributorsDto GetDistributor(int id) throws IllegalStateException;

    List<DistributorsDto> GetAllDistributors() throws RuntimeException;
}
