package com.example.Inventory.controller;

import com.example.Inventory.models.Item;
import com.example.Inventory.servies.ItemServies;
import com.example.Inventory.servies.OrderServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemServies itemServies;
    private final OrderServies orderServies;

    @Autowired
    public ItemController(ItemServies itemServies ,OrderServies orderServies) {
        this.itemServies = itemServies;
        this.orderServies = orderServies;
    }

    @GetMapping("/retrive")
    public ResponseEntity<?> retrieveItem() {
        try {
            List<Item> items = itemServies.GetAllItem();
            return ResponseEntity.ok().body(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        try {
            itemServies.AddNewItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        try {
            itemServies.UpdateItem(item);
            return ResponseEntity.ok().body("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable(required = true) int itemId){
        try {
            itemServies.DeleteItem(itemId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/retrive/{itemId}")
    public ResponseEntity<?> retrieveItemById(@PathVariable(required = true) int itemId) {
        try {
            Item item = itemServies.GetItem(itemId);
            return ResponseEntity.ok().body(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/{itemId}/supplyed/by/{supplierId}")
    public ResponseEntity<?> suppliedBy(@PathVariable(required = true) int itemId, @PathVariable(required = true) int supplierId) {
        try {
            itemServies.supplyedBy(itemId, supplierId);
            return ResponseEntity.ok().body("Item supplied successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/{itemId}/to/order/{OrderId}")
    public ResponseEntity<?> setItemInOrder(@PathVariable(required = true) int OrderId, @PathVariable(required = true) int itemId) {
        try {
            orderServies.setItemInOrder(OrderId, itemId);
            return ResponseEntity.ok().body("Item added to order successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }
}
