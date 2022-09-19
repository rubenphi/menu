package com.rubenphi.menu.controllers;

import com.rubenphi.menu.DAO.OrderDao;
import com.rubenphi.menu.DTO.CreateOrderDto;
import com.rubenphi.menu.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDao orderDao;

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

        Order order = modelMapper.map(orderRequest, Order.class);
        return orderDao.saveOrder(order);
    }

    @PutMapping(path = "/{id}")
    public Order updateOrder(@PathVariable("id") Long id,@RequestBody CreateOrderDto orderRequest) {

        Order order = modelMapper.map(orderRequest, Order.class);
        order.setId(id);
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


}

