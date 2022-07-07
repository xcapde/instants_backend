package com.xevicorp1.instants.models;

import lombok.Data;

import javax.persistence.*;

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
    private Integer comments;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}
