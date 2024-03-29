package com.example.Inventory.servies;

import com.example.Inventory.models.Distributors;
import com.example.Inventory.models.Item;
import com.example.Inventory.models.Order;
import com.example.Inventory.repo.DistributorsRepo;
import com.example.Inventory.repo.ItemRepo;
import com.example.Inventory.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServies {

    private final OrderRepo orderRepo;

    private final ItemRepo itemRepo;

    private final DistributorsRepo distributorRepo;

    @Autowired
    public OrderServies(OrderRepo orderRepo ,ItemRepo itemRepo ,DistributorsRepo distributorRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.distributorRepo = distributorRepo;
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

    @Transactional
    public void setItemInOrder (int orderId , int itemId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        Item item = itemRepo.findById(itemId).orElse(null);
        if (order == null) {
            throw new IllegalStateException("Order with id " + orderId + " does not exist");
        }
        if (item == null) {
            throw new IllegalStateException("Item with id " + itemId + " does not exist");
        }
        order.getItem().add(item);
        orderRepo.save(order);
        item.getOrders().add(order);
        itemRepo.save(item);
    }

    @Transactional
    public void setDistributorInOrder(int orderId , int distributorId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        Distributors distributor = distributorRepo.findById(distributorId).orElse(null);
        if (order == null) {
            throw new IllegalStateException("Order with id " + orderId + " does not exist");
        }
        if (distributor == null) {
            throw new IllegalStateException("Distributor with id " + distributorId + " does not exist");
        }
        order.setDistributors(distributor);
        orderRepo.save(order);
    }
}
