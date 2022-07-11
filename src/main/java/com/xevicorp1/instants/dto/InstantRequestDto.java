package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor //És el constructor
@Builder //Patró de disseny
public class InstantRequestDto {
    private String title;
    private String description;
    private String imgUrl;
    private String location;
}
