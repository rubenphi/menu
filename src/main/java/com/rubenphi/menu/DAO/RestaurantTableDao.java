package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.RestaurantTable;

import java.util.List;

public interface RestaurantTableDao {
    List<RestaurantTable> getRestaurantTables();
    RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable);

    RestaurantTable getRestaurantTable(Long id);

    RestaurantTable updateRestaurantTable(RestaurantTable restaurantTable);

    boolean deleteRestaurantTable(Long id);
}
