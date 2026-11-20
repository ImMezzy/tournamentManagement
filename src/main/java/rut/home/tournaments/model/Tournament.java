package rut.home.tournaments.model;

import java.time.LocalDateTime;

public record Tournament(
        String title,
        String description,
        int maxParticipants,
        int participantCount,
        int prizeFund,
        LocalDateTime dateTime,
        String location,
        String format
) {
    public String registrationStatus() {
        if (LocalDateTime.now().isAfter(dateTime)) {
            return "Турнир завершён";
        }
        if (participantCount >= maxParticipants) {
            return "Набор завершён";
        }
        return "Регистрация открыта";
    }
}
