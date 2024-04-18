package org.javaacademy.car_sale_announcement.repository;

import org.javaacademy.car_sale_announcement.entity.Filter;
import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Component
public class AnnouncementRepository {
    private final Map<String, Announcement> announcements = new HashMap<>();

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

    public List<Announcement> getAnnouncementsByFilters(Filter filter) {
        return announcements.values().stream()
                .filter(announcement -> announcement.equalsCarFilters(filter))
                .toList();
    }
}

