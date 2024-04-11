package com.example.Inventory.repo;

import com.example.Inventory.models.ItemsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsOrderRepo extends JpaRepository<ItemsOrder, Long> {

}
