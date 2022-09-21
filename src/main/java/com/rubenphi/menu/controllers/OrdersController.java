package com.rubenphi.menu.controllers;

import com.rubenphi.menu.DAO.DishDao;
import com.rubenphi.menu.DAO.OrderDao;
import com.rubenphi.menu.DAO.RestaurantTableDao;
import com.rubenphi.menu.DAO.UserDao;
import com.rubenphi.menu.DTO.AddOrderDishDto;
import com.rubenphi.menu.DTO.CreateOrderDto;
import com.rubenphi.menu.DTO.UpdateOrderDto;
import com.rubenphi.menu.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DishDao dishDao;


    @Autowired
    private RestaurantTableDao tableDao;

    @GetMapping()
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @GetMapping(path = "/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderDao.getOrder(id);
    }

    @PostMapping()
    public Order saveOrder(@RequestBody CreateOrderDto orderRequest) {
        RestaurantTable table = tableDao.getRestaurantTable(orderRequest.getTableId());
        User waiter = userDao.getUser(orderRequest.getWaiterId());
        Order order = new Order();
        order.setCode(orderRequest.getCode());
        order.setWaiter(waiter);
        order.setTable(table);
        return orderDao.saveOrder(order);
    }

    @PutMapping(path = "/{id}")
    public Order updateOrder(@PathVariable("id") Long id,@RequestBody UpdateOrderDto orderRequest) {
        RestaurantTable table = tableDao.getRestaurantTable(orderRequest.getTableId());
        User waiter = userDao.getUser(orderRequest.getWaiterId());
        Order order = new Order();
        order.setId(id);
        order.setCode(orderRequest.getCode());
        order.setWaiter(waiter);
        order.setTable(table);
        order.setCreatedAt(orderDao.getOrder(id).getCreatedAt());
        return orderDao.updateOrder(order);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        boolean elimination = orderDao.deleteOrder(id);

        if (elimination) {
            return "Order with id " + id + " deleted successful";
        } else {
            return "Order with id " + id + " don't deleted";
        }

    }



    @PostMapping(path = "/{id}/dishes")
    public OrderDish addDish(@PathVariable("id") Long id, @RequestBody AddOrderDishDto dishToOrderRequest) {
        Order order = orderDao.getOrder(id);
        Dish dish = dishDao.getDish(dishToOrderRequest.getDishId());
        OrderDish orderDish = new OrderDish();
        orderDish.setOrder(order);
        orderDish.setDish(dish);
        orderDish.setAmount(dishToOrderRequest.getAmount());
        return orderDao.saveOrderDish(orderDish);
    }

    @GetMapping(path = "/{id}/dishes")
    public List<OrderDish> getOrderDishes(@PathVariable("id") Long id){
        Order order = orderDao.getOrder(id);
        return order.getDishes();
    }





}

