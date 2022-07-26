package com.xevicorp1.instants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    private User creator;


    private boolean isCommented = false;
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE) // opció A
    @OneToMany(mappedBy = "instant", cascade = CascadeType.REMOVE)
    private List<Comment> commentsList = new ArrayList<>();
    @JsonSerialize
    public int commentsCount(){
        return this.commentsList.size();
    }


    private boolean isLiked = false;

// Utilitzar equals compara només l'atribut (User), == compara la memòria.
    public boolean isLiked (User lover) {
        var likeLover =  likesList.stream().filter(Like -> Like.getLover() == (lover)).findFirst();
        if (likeLover.isEmpty()) return false;
        return true;
    };

    @OneToMany(mappedBy = "instant")
    private List<Like> likesList = new ArrayList<>();

    public void addLike(Like newLike){
        if(!newLike.getInstant().equals(this)) return;
        if(newLike.getInstant().isLiked(newLike.getLover())) return;;
        likesList.add(newLike);
    }
    @JsonSerialize
    public int likesCount() {
        return this.likesList.size();
    }
}
