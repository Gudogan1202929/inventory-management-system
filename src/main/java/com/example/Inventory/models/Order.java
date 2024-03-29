package com.example.Inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            columnDefinition = "TEXT",
            nullable = false)
    private OrderStatus status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Distributors distributors;

    @ManyToMany(mappedBy = "orders")
    private List<Item> item = new ArrayList<>();

    @Column(name = "date",
            columnDefinition = "DATE",
            nullable = false)
    Date date = new Date();



    public Order() {
    }

    public Order(int id,OrderStatus status, List<Item> item, Date date) {
        this.id = id;
        this.status = status;
        this.item = item;
        this.date = date;
    }

    public Order(int id, OrderStatus status, Distributors distributors, List<Item> item, Date date) {
        this.id = id;
        this.status = status;
        this.distributors = distributors;
        this.item = item;
        this.date = date;
    }

    public Order( OrderStatus status, Date date) {
        this.status = status;
        this.date = date;
    }

    public Order(OrderStatus status, Date date , Distributors distributors) {
        this.status = status;
        this.distributors = distributors;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Distributors getDistributors() {
        return distributors;
    }

    public void setDistributors(Distributors distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", item=" + item +
                ", date=" + date +
                '}';
    }

}
