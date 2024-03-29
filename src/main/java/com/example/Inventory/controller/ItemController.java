package com.example.Inventory.controller;

import com.example.Inventory.models.Item;
import com.example.Inventory.servies.ItemServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemServies itemServies;

    @Autowired
    public ItemController(ItemServies itemServies) {
        this.itemServies = itemServies;
    }

    @GetMapping("/item/retrieve")
    public ResponseEntity<?> retrieveItem() {
        try {
            List<Item> items = itemServies.GetAllItem();
            return ResponseEntity.ok().body(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/item/add")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        try {
            itemServies.AddNewItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/item/update")
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        try {
            itemServies.UpdateItem(item);
            return ResponseEntity.ok().body("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(required = true) int id){
        try {
            itemServies.DeleteItem(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/item/retrieve/{id}")
    public ResponseEntity<?> retrieveItemById(@PathVariable(required = true) int id) {
        try {
            Item item = itemServies.GetItem(id);
            return ResponseEntity.ok().body(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }
}
