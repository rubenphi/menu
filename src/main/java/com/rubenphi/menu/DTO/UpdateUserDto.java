package com.rubenphi.menu.DTO;

import lombok.Getter;
import lombok.Setter;

public class UpdateUserDto {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String role;
}
