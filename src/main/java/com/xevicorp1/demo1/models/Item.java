package com.xevicorp1.demo1.models;

public class Item {

    private String title;
    private String description;
    private String imageUrl;
    private Long id;

    public Item(String title, String description, String imageUrl, Long id) {
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
    }
}
