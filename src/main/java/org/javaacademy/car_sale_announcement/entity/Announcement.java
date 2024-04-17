package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Announcement {
    private String id;
    @NonNull
    private String nameBrand;
    @NonNull
    private Color color;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String model;
    @NonNull
    private LocalDateTime timePlacement;
}
