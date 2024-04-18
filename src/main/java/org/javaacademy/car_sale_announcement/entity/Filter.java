package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;

@Data
public class Filter {
    private final String nameBrand;
    private final String color;
    private final String price;
    private final String model;
}
