package com.xevicorp1.instants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "instants")
@NoArgsConstructor
@AllArgsConstructor
public class Instant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private String location;

    @ManyToOne
    @JoinColumn(name = "creator_id")
//    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "instant")
    private List<Comment> comments = new ArrayList<>();
    @JsonSerialize
    public int commentsCount(){
        return this.comments.size();
    }


    @OneToMany(mappedBy = "instant")
    private List<Like> likesList = new ArrayList<>();

    public void addLike(Like like){
        likesList.add(like);
    }
    public int likesCount() {
        return 1;
    }
}
