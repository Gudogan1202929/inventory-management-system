package com.example.Inventory.dto;

import com.example.Inventory.models.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SupplyingCompanyDto implements Serializable {
        private int id;
        private String companyName;
        private String phoneNumber;
        private String location;
        private String email;
        private List<Item> items = new ArrayList<>();

        public SupplyingCompanyDto(String companyName, String phoneNumber, String location, String email) {
            this.companyName = companyName;
            this.phoneNumber = phoneNumber;
            this.location = location;
            this.email = email;
        }

        public SupplyingCompanyDto(int id, String companyName, String phoneNumber, String location, String email, List<Item> items) {
            this.id = id;
            this.companyName = companyName;
            this.phoneNumber = phoneNumber;
            this.location = location;
            this.email = email;
            this.items = items;
        }

        public SupplyingCompanyDto(int id, String companyName, String phoneNumber, String location, String email) {
            this.id = id;
            this.companyName = companyName;
            this.phoneNumber = phoneNumber;
            this.location = location;
            this.email = email;
        }

        public SupplyingCompanyDto() {
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
