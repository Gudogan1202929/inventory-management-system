package com.example.Inventory.dto;

import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;

import java.io.Serializable;

public class ItemsOrderDto implements Serializable {
        private Long id;
        private Order order;
        private Item item;
        private int quantity;

        public ItemsOrderDto() {
        }

        public ItemsOrderDto(Order order, Item item, int quantity) {
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
