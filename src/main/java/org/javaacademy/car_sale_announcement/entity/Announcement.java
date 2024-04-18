package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;
import lombok.NonNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Announcement {
    private String id;
    @NonNull
    private final String nameBrand;
    @NonNull
    private final Color color;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final String model;
    @NonNull
    private final LocalDateTime timePlacement;

}
