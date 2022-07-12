package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequestDto {
    private String comment;
    private Long instantId;
}
