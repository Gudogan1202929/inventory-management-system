package com.example.Inventory.servies;

import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;
import com.example.Inventory.models.SupplyingCompany;
import com.example.Inventory.repo.ItemRepo;
import com.example.Inventory.repo.OrderRepo;
import com.example.Inventory.repo.SupplyingCompanyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServies {

    private final ItemRepo itemRepo;

    private final SupplyingCompanyRepo supplyingCompanyRepo;

    private final OrderRepo orderRepo;

    @Autowired
    public ItemServies(ItemRepo itemRepo , SupplyingCompanyRepo supplyingCompanyRepo ,OrderRepo orderRepo) {
        this.itemRepo = itemRepo;
        this.supplyingCompanyRepo = supplyingCompanyRepo;
        this.orderRepo = orderRepo;
    }

    @Transactional
    public void AddNewItem(Item item) throws RuntimeException{
        try {
            itemRepo.save(item);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new Item", e);
        }
    }


    @Transactional
    public void DeleteItem(int id) throws IllegalStateException{
        boolean exists = itemRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Item with id " + id + " does not exist");
        }
        itemRepo.deleteById(id);
    }

    @Transactional
    public void UpdateItem(Item item) throws IllegalStateException{
        System.out.println(item.toString());
        Item itemFound = itemRepo.findById(item.getId()).orElse(null);
        System.out.println(itemFound.toString());
        if (itemFound == null) {
            throw new IllegalStateException("Item with id " + item.getId() + " does not exist");
        }
        itemRepo.save(item);
    }

    @Transactional
    public Item GetItem(int id) throws IllegalStateException{
        Item item = itemRepo.findById(id).orElse(null);
        if (item == null) {
            throw new IllegalStateException("Item with id " + id + " does not exist");
        }
        return item;
    }

    @Transactional
    public List<Item> GetAllItem() throws RuntimeException{
        if (itemRepo.findAll().isEmpty()) {
            throw new RuntimeException("No Item found");
        }
        return itemRepo.findAll();
    }

    @Transactional
    public void supplyedBy( int ItemId ,int SupplyerId) {
        Item item = itemRepo.findById(ItemId).orElse(null);
        SupplyingCompany supplyingCompany = supplyingCompanyRepo.findById(SupplyerId).orElse(null);
        if (item == null) {
            throw new IllegalStateException("Item with id " + ItemId + " does not exist");
        }
        if (supplyingCompany == null) {
            throw new IllegalStateException("Suppler with id " + SupplyerId + " does not exist");
        }
        item.setSupplyingCompany(supplyingCompany);
        itemRepo.save(item);
    }
}
