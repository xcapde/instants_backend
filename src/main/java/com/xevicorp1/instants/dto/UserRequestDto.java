package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String surname;
    private String avatar;
    private String mail;
    private String password;
}
