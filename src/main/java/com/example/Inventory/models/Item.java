package com.example.Inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "items_sequence",
            sequenceName = "items_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "name",
            columnDefinition = "TEXT",
            nullable = false)
    private String name;

    @Column(name = "quantity",
            columnDefinition = "Integer",
            nullable = false)
    private int quantity;

    @Column(name = "price",
            columnDefinition = "Integer",
            nullable = false)
    private double price;
    @JsonIgnore
    @OneToMany(mappedBy = "item" ,cascade = CascadeType.PERSIST)
    private List<ItemsOrder> ItemsOrder = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "supplying_company_fk", referencedColumnName = "id")
    @JsonIgnore
    private SupplyingCompany supplyingCompany;

    public Item(String name, int quantity, double price, SupplyingCompany supplyingCompany) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplyingCompany = supplyingCompany;
    }

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {
    }

    public Item(int id, String name, int quantity, double price, List<ItemsOrder> ItemsOrder, SupplyingCompany supplyingCompany) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.ItemsOrder = ItemsOrder;
        this.supplyingCompany = supplyingCompany;
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

    public List<ItemsOrder> getOrders() {
        return ItemsOrder;
    }

    public void setOrders(List<ItemsOrder> ItemsOrder) {
        this.ItemsOrder = ItemsOrder;
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
