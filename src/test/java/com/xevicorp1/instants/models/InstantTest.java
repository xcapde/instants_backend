package com.xevicorp1.instants.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class InstantTest {

    @Test
    void shouldHasACommentsCounter() {
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

//    @Test
//    void instantShouldntLetAddLikeIfInstantIsNotTheSame() {
//        var instant1 = new Instant();
//        var instant2 = new Instant();
//        var user = new User();
//
//        var like = new Like(user,instant1);
//        instant1.addLike(like);
//
//        int sut = instant2.likesCount();
//
//        assertThat(sut, equalTo(0));
////        assertThat(sut, equalTo(1)); // perquè falli
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