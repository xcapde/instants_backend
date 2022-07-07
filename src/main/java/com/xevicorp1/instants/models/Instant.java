package com.xevicorp1.instants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "instants")
public class Instant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String image;
    private String location;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "instant")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
    @JsonSerialize
    public int commentsCount(){
        return this.comments.size();
    }
}
