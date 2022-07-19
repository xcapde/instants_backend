package com.xevicorp1.instants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor //És el constructor
@Builder //Patró de disseny per fer el Mapper
public class InstantRequestDto {
    private String title;
    private String description;
    private String imgUrl;
    private String location;
}

//    private Long id;
//    private String title;
//    private String description;
//    private String imgUrl;
//    private String location;
//    private UserPublicRequestDto creator;
//    //    private boolean isLiked;
//    private int likesCount;
//    //    private boolean isCommented;
//    private int commentsCount;
