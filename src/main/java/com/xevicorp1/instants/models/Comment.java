package com.xevicorp1.instants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String comment;
//    private Integer date;
    @ManyToOne
    @JoinColumn(name = "creator_id")
//    @JsonIgnore
    private User creator;

    @ManyToOne
    @JoinColumn(name = "instant_id")
    @JsonIgnore
    private Instant instant;
}
