package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getOrders();
    Order saveOrder(Order order);

    Order getOrder(Long id);

    Order updateOrder(Order order);

    boolean deleteOrder(Long id);
}
