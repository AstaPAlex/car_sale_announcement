package org.javaacademy.car_sale_announcement.dto;

import lombok.Data;
import org.javaacademy.car_sale_announcement.entity.Color;
import java.math.BigDecimal;

@Data
public class CarDto {
    private final String nameBrand;
    private final String color;
    private final String price;
    private final String model;
}
