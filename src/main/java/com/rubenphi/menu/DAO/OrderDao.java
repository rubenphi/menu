package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Order;
import com.rubenphi.menu.models.OrderDish;

import java.util.List;
import java.util.Set;

public interface OrderDao {

    List<Order> getOrders();
    Order saveOrder(Order order);

    Order getOrder(Long id);

    Order updateOrder(Order order);

    boolean deleteOrder(Long id);

    OrderDish saveOrderDish(OrderDish orderDish);

    Set<OrderDish> getOrderDishes(Long id);

    OrderDish getOrderDish(Long id);

    OrderDish updateOrderDish(OrderDish orderDish);

    boolean deleteOrderDish(Long id);
}
