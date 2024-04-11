package com.example.Inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "items_orders")
public class ItemsOrder {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(
                 name = "order_items_sequence",
                 sequenceName = "order_items_sequence",
                 allocationSize = 1)
        private Long id;

     @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "order_id")
     private Order order;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(nullable = false,
            columnDefinition = "Integer")
    private int quantity;


    public ItemsOrder() {
    }

    public ItemsOrder(Order order, Item item, int quantity) {
            this.order = order;
            this.item = item;
            this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemsOrder{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
