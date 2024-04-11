package com.example.Inventory.dto;

import com.example.Inventory.models.Distributors;
import com.example.Inventory.models.ItemsOrder;
import com.example.Inventory.models.OrderStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto implements Serializable {
        private int id;
        private OrderStatus status;
        private Distributors distributors;
        private List<ItemsOrder> ItemsOrder = new ArrayList<>();
        private Date date = new Date();

        public OrderDto() {
        }

        public OrderDto(int id,OrderStatus status, List<ItemsOrder> ItemsOrder, Date date) {
            this.id = id;
            this.status = status;
            this.ItemsOrder = ItemsOrder;
            this.date = date;
        }

        public OrderDto(int id, OrderStatus status, Distributors distributors, List<ItemsOrder> ItemsOrder, Date date) {
            this.id = id;
            this.status = status;
            this.distributors = distributors;
            this.ItemsOrder = ItemsOrder;
            this.date = date;
        }

        public OrderDto( OrderStatus status, Date date) {
            this.status = status;
            this.date = date;
        }

        public OrderDto(OrderStatus status, Date date , Distributors distributors) {
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

        public List<ItemsOrder> getItem() {
            return ItemsOrder;
        }

        public void setItem(List<ItemsOrder> ItemsOrder) {
            this.ItemsOrder = ItemsOrder;
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
                    ", item=" + ItemsOrder +
                    ", date=" + date +
                    '}';
        }
}
