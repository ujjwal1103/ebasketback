package com.eBasket.Ebasket.Grocery.App.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String category;
    @NonNull
    private String description;
    @NonNull
    private Integer quantity;
    @NonNull
    private Double price;
    @NonNull
    private String unit;
    @Lob
    @Column(nullable = false)
    @NonNull
    private String image;
}
