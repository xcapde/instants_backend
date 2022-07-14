package com.xevicorp1.instants.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="likes")
@NoArgsConstructor
public class Like {

    public Like(User lover, Instant instant) {
        this.lover = lover;
        this.instant = instant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lover_id")
    private User lover;
    @ManyToOne
    @JoinColumn(name = "instant_id")
    private Instant instant;

}
