package org.javaacademy.car_sale_announcement.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
import org.javaacademy.car_sale_announcement.dto.CarDto;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.javaacademy.car_sale_announcement.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDtoRq announcementDtoRq) {
        Announcement announcement = announcementService.createAnnouncement(announcementDtoRq);
        return announcement == null
                ? ResponseEntity.status(BAD_REQUEST).build()
                : ResponseEntity.status(CREATED).body(announcement);
    }

    @GetMapping("/date/{date}")
    public List<Announcement> getAnnouncementByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return announcementService.getAnnouncementsByDate(localDate);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable String key) {
        return announcementService.deleteByKey(key)
                ? ResponseEntity.status(ACCEPTED).build()
                : ResponseEntity.status(NOT_FOUND).build();
    }

    @GetMapping
    public List<Announcement> getAnnouncementByFilters(@RequestParam(required = false) String nameBrand,
                                                    @RequestParam(required = false) String color,
                                                    @RequestParam(required = false) String price,
                                                    @RequestParam(required = false) String model) {
        CarDto carDto = new CarDto(nameBrand, color, price, model);
        return announcementService.getAnnouncementsByFilters(carDto);
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<?> getAnnouncementByKey(@PathVariable String key) {
        Optional<Announcement> announcementOpt = announcementService.getAnnouncementByKey(key);
        return announcementOpt.isPresent()
                ? ResponseEntity.status(ACCEPTED).body(announcementOpt.get())
                : ResponseEntity.status(NOT_FOUND).build();
    }

}
