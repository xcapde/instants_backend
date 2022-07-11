package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //És el constructor
public class InstantRequestDto {
    private String title;
    private String description;
    private String imgUrl;
    private String location;
}
