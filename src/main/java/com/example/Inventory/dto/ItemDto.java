package com.example.Inventory.dto;

import com.example.Inventory.models.SupplyingCompany;
import java.io.Serializable;

public class ItemDto implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private double price;

    private SupplyingCompany supplyingCompany;


    public ItemDto(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public ItemDto(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public ItemDto(int id, String name, int quantity, double price, SupplyingCompany supplyingCompany) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplyingCompany = supplyingCompany;
    }

    public ItemDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SupplyingCompany getSupplyingCompany() {
        return supplyingCompany;
    }

    public void setSupplyingCompany(SupplyingCompany supplyingCompany) {
        this.supplyingCompany = supplyingCompany;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price;
    }
}