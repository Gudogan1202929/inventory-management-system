package com.example.Inventory.repo;

import com.example.Inventory.dto.ItemDto;
import com.example.Inventory.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
    Item findByName(String name);
}
