package com.rubenphi.menu.controllers;

import com.rubenphi.menu.DAO.DishDao;
import com.rubenphi.menu.DTO.CreateDishDto;
import com.rubenphi.menu.DTO.UpdateDishDto;
import com.rubenphi.menu.models.Dish;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DishDao dishDao;

    @GetMapping()
    public List<Dish> getDishes() {
        return dishDao.getDishes();
    }

    @GetMapping(path = "/{id}")
    public Dish getDish(@PathVariable("id") Long id) {
        return dishDao.getDish(id);
    }

    @PostMapping()
    public Dish saveDish(@RequestBody CreateDishDto dishRequest) {

        Dish dish = modelMapper.map(dishRequest, Dish.class);
        return dishDao.saveDish(dish);
    }

    @PutMapping(path = "/{id}")
    public Dish updateDish(@PathVariable("id") Long id,@RequestBody UpdateDishDto dishRequest) {

        Dish dish = modelMapper.map(dishRequest, Dish.class);
        dish.setId(id);
        dish.setCreatedAt(dishDao.getDish(id).getCreatedAt());
        return dishDao.updateDish(dish);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDish(@PathVariable("id") Long id) {
        boolean elimination = dishDao.deleteDish(id);

        if (elimination) {
            return "Dish with id " + id + " deleted successful";
        } else {
            return "Dish with id " + id + " don't deleted";
        }

    }


}
