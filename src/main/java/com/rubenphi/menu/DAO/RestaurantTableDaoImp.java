package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Dish;
import com.rubenphi.menu.models.RestaurantTable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RestaurantTableDaoImp implements RestaurantTableDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RestaurantTable> getRestaurantTables() {
        String query = "FROM RestaurantTable";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable) {
        return entityManager.merge(restaurantTable);
    }

    @Override
    public RestaurantTable getRestaurantTable(Long id) {
        RestaurantTable restaurantTable = entityManager.find(RestaurantTable.class, id);
        return restaurantTable;
    }

    @Override
    public RestaurantTable updateRestaurantTable(RestaurantTable restaurantTable) {
        return entityManager.merge(restaurantTable);
    }

    @Override
    public boolean deleteRestaurantTable(Long id) {
        try {
            RestaurantTable restaurantTable = entityManager.find(RestaurantTable.class, id);
            entityManager.remove(restaurantTable);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
