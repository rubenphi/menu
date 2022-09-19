package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DishDaoImp implements DishDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Dish> getDishes(){
        String query = "FROM Dish";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public Dish saveDish(Dish dish) {
        return entityManager.merge(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return entityManager.merge(dish);
    }

    @Override
    public Dish getDish(Long id) {
        Dish dish = entityManager.find(Dish.class, id);
        return dish;
    }

    @Override
    public boolean deleteDish(Long id) {
        try {
            Dish dish = entityManager.find(Dish.class, id);
            entityManager.remove(dish);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
