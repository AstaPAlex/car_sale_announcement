package org.javaacademy.car_sale_announcement.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
import org.javaacademy.car_sale_announcement.entity.Filter;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.javaacademy.car_sale_announcement.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDtoRq announcementDtoRq) {
        Announcement announcement;
        try {
            announcement = announcementService.createAnnouncement(announcementDtoRq);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(announcement);
    }

    @GetMapping("/date/{date}")
    public List<Announcement> getAnnouncementByDate(@PathVariable LocalDate date) {
        return announcementService.getAnnouncementsByDate(date);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable String key) {
        return announcementService.deleteByKey(key)
                ? ResponseEntity.status(HttpStatus.ACCEPTED).build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public List<Announcement> getAnnouncementsByFilters(@Validated Filter filter) {
        return announcementService.getAnnouncementsByFilters(filter);
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<?> getAnnouncementByKey(@PathVariable String key) {
        Announcement announcement;
        try {
            announcement = announcementService.getAnnouncementByKey(key);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(announcement);
    }

}
