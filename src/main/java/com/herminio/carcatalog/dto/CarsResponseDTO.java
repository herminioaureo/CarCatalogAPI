package com.herminio.carcatalog.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarsResponseDTO {

    private Long id;
    private String model;
    private Integer year;
    private Double price;
    private String image;
}
