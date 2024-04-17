package org.javaacademy.car_sale_announcement.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.javaacademy.car_sale_announcement.entity.Color;
import org.javaacademy.car_sale_announcement.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    //POST http://localhost:8003/announcement - создание нового объявления
    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDtoRq announcementDtoRq) {
        Announcement announcement = announcementService.createAnnouncement(announcementDtoRq);
        System.out.println(announcement);
        return announcement == null
                ? ResponseEntity.status(BAD_REQUEST).build()
                : ResponseEntity.status(CREATED).build();
    }

/*    //GET http://localhost:8080/book/key - получение объявления за дату
    @GetMapping("/{key}")
    public Announcement getAnnouncementByDate(@PathVariable LocalDate date) {

    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable String key) {

    }

    @GetMapping
    public List<Announcement> getAnnouncementByKeys(@RequestParam(required = false) String nameBrand,
                                                    @RequestParam(required = false) Color color,
                                                    @RequestParam(required = false) BigDecimal price,
                                                    @RequestParam(required = false) String model) {

    }

    @GetMapping("/{key}")
    public Announcement getAnnouncementByKey(@PathVariable String key) {

    }*/



}
