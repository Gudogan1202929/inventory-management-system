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
@Table(name = "distributors")
public class Distributors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "distributors_sequence",
            sequenceName = "distributors_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "name",
            columnDefinition = "TEXT",
            nullable = false)
    private String name;

    @Column(name = "address",
            columnDefinition = "TEXT",
            nullable = false)
    private String address;

    @Column(name = "phone",
            columnDefinition = "TEXT",
            nullable = false)
    private String phone;

    @Column(name = "email",
            columnDefinition = "TEXT")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "distributors" ,cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Distributors(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Distributors() {
    }

    public Distributors(int id, String name, String address, String phone, String email, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.orders = orders;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Distributors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
