package com.xevicorp1.demo1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="items")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String title;
    private String description;
    private String imageUrl;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /*public Item(String title, String description, String imageUrl, Long id) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getId() {
        return id;
    }*/
}
