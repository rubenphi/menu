package com.rubenphi.menu.DTO;

import lombok.Getter;
import lombok.Setter;

public class CreateOrderDto {
    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private Long waiterId;
    @Setter
    @Getter
    private Long tableId;

}
