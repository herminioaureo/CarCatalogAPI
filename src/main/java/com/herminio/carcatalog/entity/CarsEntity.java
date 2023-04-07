package com.herminio.carcatalog.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cars")
@Entity(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer year;
    private Double price;
    private String image;

}
