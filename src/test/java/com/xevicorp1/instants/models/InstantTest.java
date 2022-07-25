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
    void instantShouldNotAllowAddLikeToAnotherInstant() {
        var instant1 = new Instant();
        var instant2 = new Instant();
        var user = new User();
        var like = new Like(user,instant1);
        instant1.addLike(like);

        int sut = instant2.likesCount();

        assertThat(sut, equalTo(0));
//        assertThat(sut, equalTo(1)); // perquè falli
    }

    @Test
    void instantShouldKnowIfAnUserLikedIt() {
        var instant = new Instant();
        var lover = new User();
        var like = new Like(lover,instant);
        instant.addLike(like);

        var sut = instant.isLiked(lover);

        assertThat(sut, equalTo(true));
//        assertThat(sut, equalTo(false)); // perquè falli
    }
    @Test
    void instantShouldNotAllowUserToAddMoreThanOneLikeInTheSameInstant() {
        var instant1 = new Instant();
        var lover1 = new User();
        var like1 = new Like(lover1, instant1);
        var like2 = new Like(lover1, instant1);
        instant1.addLike(like1);
        instant1.addLike(like2);

        var sut = instant1.likesCount();

        assertThat(sut, equalTo(1));
//        assertThat(sut, equalTo(2)); // Perquè falli
    }

    @Test
    void instantShouldKnowIfAnUserDoesNotLikeIt() {
        var instant = new Instant();
        var lover = new User();
        var notLover = new User();
        var like = new Like(lover,instant);
        instant.addLike(like);

        var sut = instant.isLiked(notLover);

        assertThat(sut, equalTo(false));
//        assertThat(sut, equalTo(true)); // perquè falli
    }

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