package org.javaacademy.car_sale_announcement.repository;

import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class AnnouncementRepository {
    Map<String, Announcement> announcements = new HashMap<>();

    public Announcement add(Announcement announcement) {
        UUID uuid = UUID.randomUUID();
        announcement.setId(uuid.toString());
        announcements.put(uuid.toString(), announcement);
        return announcement;
    }

    public List<Announcement> getAnnouncementsByDate(LocalDate date) {
        return announcements.values().stream()
                .filter(announcement -> announcement.getTimePlacement().toLocalDate().equals(date))
                .toList();
    }

    public boolean deleteByKey(String key) {
        return announcements.remove(key) != null;
    }

    public Optional<Announcement> getAnnouncementByKey(String key) {
        return Optional.ofNullable(announcements.get(key));
    }
}

