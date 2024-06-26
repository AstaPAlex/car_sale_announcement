package org.javaacademy.car_sale_announcement.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.car_sale_announcement.dto.AnnouncementDtoRq;
import org.javaacademy.car_sale_announcement.entity.Filter;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.javaacademy.car_sale_announcement.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    public Announcement createAnnouncement(AnnouncementDtoRq announcementDtoRq) {
        Announcement newAnnouncement = convertToEntity(announcementDtoRq);
        return announcementRepository.add(newAnnouncement);
    }

    public List<Announcement> getAnnouncementsByDate(LocalDate date) {
        return announcementRepository.getAnnouncementsByDate(date);
    }

    public boolean deleteByKey(String key) {
        return announcementRepository.deleteByKey(key);
    }


    private Announcement convertToEntity(AnnouncementDtoRq announcementDtoRq) {
        return new Announcement(
                    checkNotEmpty(announcementDtoRq.getNameBrand()),
                    announcementDtoRq.getColor(),
                    getPrice(announcementDtoRq),
                    checkNotEmpty(announcementDtoRq.getModel()),
                    LocalDateTime.now());
    }

    private BigDecimal getPrice(AnnouncementDtoRq announcementDtoRq) {
        if (announcementDtoRq.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Цена меньше 0");
        }
        return announcementDtoRq.getPrice();
    }

    private String checkNotEmpty(String str) {
        if (str.isEmpty()) {
            throw new RuntimeException("Пользователь не заполнил строку");
        }
        return str;
    }

    public Announcement getAnnouncementByKey(String key) {
        return announcementRepository.getAnnouncementByKey(key).orElseThrow();
    }

    public List<Announcement> getAnnouncementsByFilters(Filter filter) {
        return announcementRepository.getAnnouncementsByFilters(filter);
    }
}
