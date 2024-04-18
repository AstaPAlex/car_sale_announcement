package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;
import lombok.NonNull;
import org.javaacademy.car_sale_announcement.dto.CarDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Announcement {
    private String id;
    @NonNull
    private LocalDateTime timePlacement;
    private final Car car;

    public Announcement(String nameBrand, Color color, BigDecimal price, String model, LocalDateTime timePlacement) {
        this.timePlacement = timePlacement;
        this.car = new Car(nameBrand, color, price, model);
    }

    public boolean equalsCarFilters(CarDto carDto) {
        return car.equalsFilters(carDto);
    }
}
