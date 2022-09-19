package com.rubenphi.menu.controllers;

import com.rubenphi.menu.DAO.RestaurantTableDao;
import com.rubenphi.menu.DTO.CreateRestaurantTableDto;
import com.rubenphi.menu.DTO.UpdateRestaurantTableDto;
import com.rubenphi.menu.models.RestaurantTable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestaurantTableDao restaurantTableDao;

    @GetMapping()
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTableDao.getRestaurantTables();
    }

    @GetMapping(path = "/{id}")
    public RestaurantTable getRestaurantTable(@PathVariable("id") Long id) {
        return restaurantTableDao.getRestaurantTable(id);
    }

    @PostMapping()
    public RestaurantTable saveRestaurantTable(@RequestBody CreateRestaurantTableDto restaurantTableRequest) {

        RestaurantTable restaurantTable = modelMapper.map(restaurantTableRequest, RestaurantTable.class);
        return restaurantTableDao.saveRestaurantTable(restaurantTable);
    }

    @PutMapping(path = "/{id}")
    public RestaurantTable updateRestaurantTable(@PathVariable("id") Long id,@RequestBody UpdateRestaurantTableDto restaurantTableRequest) {

        RestaurantTable restaurantTable = modelMapper.map(restaurantTableRequest, RestaurantTable.class);
        restaurantTable.setId(id);
        restaurantTable.setCreatedAt(restaurantTableDao.getRestaurantTable(id).getCreatedAt());
        return restaurantTableDao.updateRestaurantTable(restaurantTable);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRestaurantTable(@PathVariable("id") Long id) {
        boolean elimination = restaurantTableDao.deleteRestaurantTable(id);

        if (elimination) {
            return "RestaurantTable with id " + id + " deleted successful";
        } else {
            return "RestaurantTable with id " + id + " don't deleted";
        }
    }

}
