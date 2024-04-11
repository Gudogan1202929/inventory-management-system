package com.example.Inventory.servies.impl;

import com.example.Inventory.models.Item;
import com.example.Inventory.models.SupplyingCompany;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ItemServiceInterface {


    void AddNewItem(Item item) throws RuntimeException;


    void DeleteItem(int id) throws IllegalStateException;

    void UpdateItem(Item item) throws IllegalStateException;

    Item GetItem(int id) throws IllegalStateException;

    public List<Item> GetAllItem() throws RuntimeException;

    public void supplyedBy( int ItemId ,int SupplyerId) throws IllegalStateException;
}
