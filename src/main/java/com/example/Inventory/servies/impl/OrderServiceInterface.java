package com.example.Inventory.servies.impl;

import com.example.Inventory.dto.OrderDto;
import com.example.Inventory.models.Distributors;
import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface OrderServiceInterface {

    void AddNewOrder(Order order) throws RuntimeException;

    void DeleteOrder(int id) throws IllegalStateException;

    void UpdateOrder(Order order) throws IllegalStateException;

    OrderDto GetOrder(int id) throws IllegalStateException;

    List<OrderDto> GetAllOrder() throws RuntimeException;

    void setItemInOrder (int orderId , int itemId, int quantity) throws IllegalStateException;

    void setDistributorInOrder(int orderId , int distributorId) throws IllegalStateException;
}
