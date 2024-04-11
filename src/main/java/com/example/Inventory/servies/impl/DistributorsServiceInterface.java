package com.example.Inventory.servies.impl;

import com.example.Inventory.models.Distributors;

import java.util.List;

public interface DistributorsServiceInterface {


    void AddNewDistributor(Distributors distributors) throws RuntimeException;

    void DeleteDistributor(int id) throws IllegalStateException;

    void UpdateDistributor(Distributors distributors) throws IllegalStateException;

    Distributors GetDistributor(int id) throws IllegalStateException;

    List<Distributors> GetAllDistributors() throws RuntimeException;
}
