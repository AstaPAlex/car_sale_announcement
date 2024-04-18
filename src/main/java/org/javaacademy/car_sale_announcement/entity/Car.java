package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;
import lombok.NonNull;
import org.javaacademy.car_sale_announcement.dto.CarDto;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Car {
    @NonNull
    private final String nameBrand;
    @NonNull
    private final Color color;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final String model;

    public boolean equalsFilters(CarDto car) {
        return equalsWithNull(nameBrand, car.getNameBrand())
                && equalsWithNull(price.toString(), car.getPrice())
                && equalsWithNull(color.getColor(), car.getColor())
                && equalsWithNull(model, car.getModel());
    }

    private boolean equalsWithNull(String param, String filter) {
        if (filter == null) {
            return true;
        }
        return Objects.equals(param, filter);
    }
}
