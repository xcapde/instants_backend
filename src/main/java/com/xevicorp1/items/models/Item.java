package com.xevicorp1.items.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="items")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String title;
    private String description;
    private String image_url;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments = new ArrayList<>();

    @JsonSerialize //perquè s'executi la funció aquesta expressament
    public int commentsCount(){
        return this.comments.size();
    }

    public Item(String title, String description, String image_url, Long id) {
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

//    public Item(String title, String description, String imageUrl, Long id) {
//        this.title = title;
//        this.description = description;
//        this.imageUrl = imageUrl;
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }

    public Long getId() {
        return id;
    }
}
