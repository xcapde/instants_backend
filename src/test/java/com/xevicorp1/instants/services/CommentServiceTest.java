package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.CommentRequestDto;
import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.ICommentRepository;
import com.xevicorp1.instants.respositories.IInstantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
class CommentServiceTest {

    @Mock
    ICommentRepository mockCommentRepository;
    @Mock
    IInstantRepository mockInstantRepository;

    @Test
    void getAllReturnsListOfComments() {
        var commentService = new CommentService(mockCommentRepository, mockInstantRepository);
        var commentList = List.of(new Comment(), new Comment(), new Comment());

        Mockito.when(mockCommentRepository.findAll()).thenReturn(commentList);

        // SYSTEM UNDER TEST
        var sut = commentService.getAll();

        // THEN
        assertThat(sut.size(),equalTo(3) );
//        assertThat(sut.size(),equalTo(1) ); // Perquè falli
    }

    @Test
    void createSaveANewCommentFromDTO() {
        var commentService = new CommentService(mockCommentRepository, mockInstantRepository);

        var id = 2L;
        var instantToComment = new Instant();
        instantToComment.setId(id);

        var commentRequest = new CommentRequestDto("Visca els testos",id);
        var creator = new User();
        creator.setId(1L);

        var comment = new Comment();
        comment.setId(1L);
        comment.setComment("Visca els testos");
        comment.setCreator(creator);
        comment.setInstant(instantToComment);

        Mockito.when(mockInstantRepository.findById(any(Long.class))).thenReturn(Optional.of(instantToComment));
        Mockito.when(mockCommentRepository.save(any(Comment.class))).thenReturn(comment);

        // SYSTEM UNDER TEST
        var sut = commentService.create(commentRequest, creator);

        // THEN
        assertThat(sut.getCreator(),equalTo(creator) );
//        assertThat(sut.getInstant(),equalTo(instantToComment) );
//        assertThat(sut.getCreator(),equalTo(new User()) ); // Perquè falli
    }
}