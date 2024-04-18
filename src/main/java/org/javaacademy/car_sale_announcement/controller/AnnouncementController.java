package org.javaacademy.car_sale_announcement.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
import org.javaacademy.car_sale_announcement.dto.CarDto;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.javaacademy.car_sale_announcement.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDtoRq announcementDtoRq) {
        Announcement announcement = announcementService.createAnnouncement(announcementDtoRq);
        return announcement == null
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
                : ResponseEntity.status(HttpStatus.CREATED).body(announcement);
    }

    @GetMapping("/date/{date}")
    public List<Announcement> getAnnouncementByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return announcementService.getAnnouncementsByDate(localDate);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable String key) {
        return announcementService.deleteByKey(key)
                ? ResponseEntity.status(HttpStatus.ACCEPTED).build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
                ? ResponseEntity.status(HttpStatus.ACCEPTED).body(announcementOpt.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
