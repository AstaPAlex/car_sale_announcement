package org.javaacademy.car_sale_announcement.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
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

    //POST http://localhost:8003/announcement - создание нового объявления
    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDtoRq announcementDtoRq) {
        Announcement announcement = announcementService.createAnnouncement(announcementDtoRq);
        //System.out.println(announcement);
        //System.out.println(announcement.getTimePlacement().toLocalDate());
        return announcement == null
                ? ResponseEntity.status(BAD_REQUEST).build()
                : ResponseEntity.status(CREATED).body(announcement);
    }

    //GET http://localhost:8080/book/key - получение объявления за дату
    @GetMapping
    public List<Announcement> getAnnouncementByDate(@RequestParam String date) {
        //System.out.println(date);
        LocalDate localDate = LocalDate.parse(date);
        return announcementService.getAnnouncementsByDate(localDate);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAnnouncement(@RequestParam String key) {
        return announcementService.deleteByKey(key)
                ? ResponseEntity.status(ACCEPTED).build()
                : ResponseEntity.status(NOT_FOUND).build();
    }

/*    @GetMapping
    public List<Announcement> getAnnouncementByKeys(@RequestParam(required = false) String nameBrand,
                                                    @RequestParam(required = false) Color color,
                                                    @RequestParam(required = false) BigDecimal price,
                                                    @RequestParam(required = false) String model) {

    }*/

    @GetMapping("/{key}")
    public ResponseEntity<?> getAnnouncementByKey(@PathVariable String key) {
        Optional<Announcement> announcementByKey = announcementService.getAnnouncementByKey(key);
        return announcementByKey.isPresent()
                ? ResponseEntity.status(ACCEPTED).body(announcementByKey.get())
                : ResponseEntity.status(NOT_FOUND).build();
    }

}
