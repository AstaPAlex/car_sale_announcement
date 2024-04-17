package org.javaacademy.car_sale_announcement.repository;

import org.javaacademy.car_sale_announcement.entity.Announcement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class AnnouncementRepository {
    Map<String, Announcement> announcements = new HashMap<>();

    public Announcement add(Announcement announcement) {
        UUID uuid = UUID.randomUUID();
        announcement.setId(uuid.toString());
        announcements.put(uuid.toString(), announcement);
        return announcement;
    }
}
