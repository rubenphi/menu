package com.rubenphi.menu.DTO;

import lombok.Getter;
import lombok.Setter;

public class AddOrderDishDto {
    @Setter
    @Getter
    private Long dishId;
    @Setter
    @Getter
    private Integer amount;
}
