package com.xevicorp1.instants.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class InstantTest {

    @Test
    void shouldHasACommentCounter() {
        var instant = new Instant();
        var commentsList = List.of(new Comment(), new Comment());
        instant.setCommentsList(commentsList);

        int sut = instant.commentsCount();

        assertThat(sut, equalTo(2));
//        assertThat(sut, equalTo(1)); // perquè falli
    }

    @Test
    void shouldHasALikeCounter() {
        var instant = new Instant();
        var user = new User();
        var like = new Like(user,instant);
        instant.addLike(like);
        int sut = instant.likesCount();

        assertThat(sut, equalTo(1));
//        assertThat(sut, equalTo(0)); // perquè falli
    }

    @Test
    void instantShouldntAllowAddLikeToAnotherInstant() {
        var instant1 = new Instant();
        var instant2 = new Instant();
        var user = new User();
        var like = new Like(user,instant1);
        instant1.addLike(like);

        int sut = instant2.likesCount();

        assertThat(sut, equalTo(0));
//        assertThat(sut, equalTo(1)); // perquè falli
    }

//    @Test
//    void instantShouldntAllowUserToRepeatAddMoreThanOneLike() {
//        var instant = new Instant();
//        var lover = new User();
//        var lover2 = new User();
//        var like1 = new Like(lover,instant);
//        var like2 = new Like(lover2,instant);
//        instant.addLike(like1);
//        instant.addLike(like2);
//
//        var sut = instant.getLikesList();
//
////        assertThat(sut, equalTo(1));
//        assertThat(sut, equalTo(2)); // perquè falli
//    }

//    @Test
//    void getId() {
//    }
//
//    @Test
//    void getTitle() {
//    }
//
//    @Test
//    void getDescription() {
//    }
//
//    @Test
//    void getImgUrl() {
//    }
//
//    @Test
//    void getLocation() {
//    }
//
//    @Test
//    void getCreator() {
//    }
}