package com.example.Inventory.servies;

import com.example.Inventory.models.Order;
import com.example.Inventory.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServies {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServies(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Transactional
    public void AddNewOrder(Order order) throws RuntimeException{
        try {
            orderRepo.save(order);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add new order", e);
        }
    }


    @Transactional
    public void DeleteOrder(int id) throws IllegalStateException{
        boolean exists = orderRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        orderRepo.deleteById(id);
    }

    @Transactional
    public void UpdateOrder(Order order) throws IllegalStateException{
        Order orderFound = orderRepo.findById(order.getId()).orElse(null);
        if (orderFound == null) {
            throw new IllegalStateException("Order with id " + order.getId() + " does not exist");
        }
        orderRepo.save(order);
    }

    @Transactional
    public Order GetOrder(int id) throws IllegalStateException{
        Order order = orderRepo.findById(id).orElse(null);
        if (order == null) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        return order;
    }

    @Transactional
    public List<Order> GetAllOrder() throws RuntimeException{
        if (orderRepo.findAll().isEmpty()) {
            throw new RuntimeException("No Order found");
        }
        return orderRepo.findAll();
    }
}
