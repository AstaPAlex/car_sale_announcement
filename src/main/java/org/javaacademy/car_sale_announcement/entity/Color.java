package org.javaacademy.car_sale_announcement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Color {
    RED("Красный"), BLUE("Синий"), GREEN("Зеленый"), WHITE("Белый"), BLACK("Черный");

    String color;

    @JsonValue
    public String getColor() {
        return color;
    }
}
