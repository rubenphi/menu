package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImp implements OrderDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Order> getOrders(){
        String query = "FROM Order";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public Order saveOrder(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public Order getOrder(Long id) {
        Order order = entityManager.find(Order.class, id);
        return order;
    }

    @Override
    public boolean deleteOrder(Long id) {
        try {
            Order order = entityManager.find(Order.class, id);
            entityManager.remove(order);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
