package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeRequestDto {
    private Boolean isLiked;
    private Long instant_id;
}
