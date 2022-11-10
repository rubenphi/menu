package com.rubenphi.menu.DTO;

import lombok.Getter;
import lombok.Setter;

public class CreateDishDto {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Integer price;

    @Setter
    @Getter
    private Boolean inMenu;
}
