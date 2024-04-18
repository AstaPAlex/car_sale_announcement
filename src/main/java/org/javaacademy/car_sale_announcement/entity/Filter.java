package org.javaacademy.car_sale_announcement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@NoArgsConstructor
@Getter
@Setter
public class Filter {
    @NonNull
    private String nameBrand;
    @NonNull
    private String color;
    @NonNull
    private String price;
    @NonNull
    private String model;

}
