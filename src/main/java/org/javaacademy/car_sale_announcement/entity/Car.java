package org.javaacademy.car_sale_announcement.entity;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

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

    public boolean equalsFilters(Filter car) {
        return equalsWithNull(nameBrand, car.getNameBrand())
                && equalsWithNull(price.toString(), car.getPrice())
                && equalsWithNull(color.getColor(), car.getColor())
                && equalsWithNull(model, car.getModel());
    }

    private boolean equalsWithNull(String param, String filter) {
        if (filter == null) {
            return true;
        }
        return param.equalsIgnoreCase(filter);
    }
}
