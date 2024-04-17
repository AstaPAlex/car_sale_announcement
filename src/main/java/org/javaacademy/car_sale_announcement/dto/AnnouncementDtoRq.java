package org.javaacademy.car_sale_announcement.dto;

import lombok.Data;
import org.javaacademy.car_sale_announcement.entity.Color;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AnnouncementDtoRq {
    private String nameBrand;
    private Color color;
    private BigDecimal price;
    private String model;
}
