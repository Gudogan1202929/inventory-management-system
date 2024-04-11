package com.example.Inventory.servies.impl;

import com.example.Inventory.dto.ItemDto;
import com.example.Inventory.models.Item;
import com.example.Inventory.models.SupplyingCompany;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ItemServiceInterface {


    void AddNewItem(Item item) throws RuntimeException;


    void DeleteItem(int id) throws IllegalStateException;

    void UpdateItem(Item item) throws IllegalStateException;

    ItemDto GetItem(int id) throws IllegalStateException;

    List<ItemDto> GetAllItem() throws RuntimeException;

    void supplyedBy( int ItemId ,int SupplyerId) throws IllegalStateException;
}
