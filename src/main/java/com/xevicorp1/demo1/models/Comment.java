package com.xevicorp1.demo1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;
}
