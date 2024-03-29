package com.example.Inventory.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "supplying_company")
public class SupplyingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "SupplyingCompany_sequence",
    sequenceName = "SupplyingCompany_sequence",
    allocationSize = 1)
    private int id;

    @Column(name = "CompanyName",
    columnDefinition = "TEXT",
    nullable = false)
    private String companyName;

    @Column(name = "phoneNumber",
            columnDefinition = "TEXT",
            nullable = false)
    private String phoneNumber;

    @Column(name = "location",
            columnDefinition = "TEXT",
            nullable = false)
    private String location;

    @Column(name = "email",
            columnDefinition = "TEXT",
            nullable = false)
    private String email;

    @OneToMany(mappedBy = "supplyingCompany" ,cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public SupplyingCompany(String companyName, String phoneNumber, String location, String email) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.email = email;
    }

    public SupplyingCompany(int id, String companyName, String phoneNumber, String location, String email, List<Item> items) {
        this.id = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.email = email;
        this.items = items;
    }

    public SupplyingCompany() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SupplyingCompany{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
