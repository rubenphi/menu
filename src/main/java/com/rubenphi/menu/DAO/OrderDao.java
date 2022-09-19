package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Order;
import com.rubenphi.menu.models.OrderDish;

import java.util.List;

public interface OrderDao {

    List<Order> getOrders();
    Order saveOrder(Order order);

    Order getOrder(Long id);

    Order updateOrder(Order order);

    boolean deleteOrder(Long id);

    OrderDish saveOrderDish(OrderDish orderDish);

    List<OrderDish> getOrderDishes(Long id);

    OrderDish getOrderDish(Long id);

    OrderDish updateOrderDish(OrderDish orderDish);

    boolean deleteOrderDish(Long id);
}
