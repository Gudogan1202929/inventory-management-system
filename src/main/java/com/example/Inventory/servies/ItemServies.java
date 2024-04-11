package com.example.Inventory.servies;

import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;
import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.repo.ItemRepo;
import com.example.Inventory.repo.OrderRepo;
import com.example.Inventory.repo.SupplyingCompanyRepo;
import com.example.Inventory.servies.impl.ItemServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServies implements ItemServiceInterface {

    private final ItemRepo itemRepo;

    private final SupplyingCompanyRepo supplyingCompanyRepo;

    @Autowired
    public ItemServies(ItemRepo itemRepo , SupplyingCompanyRepo supplyingCompanyRepo) {
        this.itemRepo = itemRepo;
        this.supplyingCompanyRepo = supplyingCompanyRepo;
    }

    @Override
    @Transactional
    public void AddNewItem(Item item) throws RuntimeException {
        try {
            Item existingItem = itemRepo.findByName(item.getName());
            if (existingItem == null) {
                itemRepo.save(item);
            } else {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                itemRepo.save(existingItem);
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new Item", e);
        }
    }

    @Override
    @Transactional
    public void DeleteItem(int id) throws IllegalStateException{
        try {
            boolean exists = itemRepo.existsById(id);
            if (!exists) {
                throw new IllegalStateException("Item with id " + id + " does not exist");
            }
            itemRepo.deleteById(id);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void UpdateItem(Item item) throws IllegalStateException{
        try {
            Item itemFound = itemRepo.findById(item.getId()).orElse(null);
            if (itemFound == null) {
                throw new IllegalStateException("Item with id " + item.getId() + " does not exist");
            }
            itemRepo.save(item);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Item GetItem(int id) throws IllegalStateException{
        try {
            Item item = itemRepo.findById(id).orElse(null);
            if (item == null) {
                throw new IllegalStateException("Item with id " + id + " does not exist");
            }
            return item;
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Item> GetAllItem() throws RuntimeException{
        try {
            if (itemRepo.findAll().isEmpty()) {
                throw new RuntimeException("No Item found");
            }
            return itemRepo.findAll();
        }catch (DataAccessException e) {
            throw new RuntimeException("Error : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void supplyedBy( int ItemId ,int SupplierId) throws IllegalStateException{
        try {
            Item item = itemRepo.findById(ItemId).orElse(null);
            SupplyingCompany supplyingCompany = supplyingCompanyRepo.findById(SupplierId).orElse(null);
            if (item == null) {
                throw new IllegalStateException("Item with id " + ItemId + " does not exist");
            }
            if (supplyingCompany == null) {
                throw new IllegalStateException("Suppler with id " + SupplierId + " does not exist");
            }
            item.setSupplyingCompany(supplyingCompany);
            itemRepo.save(item);
        }catch (DataAccessException e) {
            throw new IllegalStateException("Error : " + e.getMessage());
        }
    }
}
