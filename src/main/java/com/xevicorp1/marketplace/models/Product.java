package com.xevicorp1.marketplace.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String image;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}
