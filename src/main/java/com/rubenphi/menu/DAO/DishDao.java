package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Dish;

import java.util.List;

public interface DishDao {
    List<Dish> getDishes();
    Dish saveDish(Dish dish);

    Dish getDish(Long id);

    Dish updateDish(Dish dish);

    boolean deleteDish(Long id);
}
