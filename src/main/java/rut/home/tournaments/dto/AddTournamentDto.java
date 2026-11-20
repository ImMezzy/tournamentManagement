package rut.home.tournaments.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class AddTournamentDto {
    @NotBlank(message = "Введите название турнира")
    @Size(max = 100, message = "Не более 100 символов")
    private String title;

    @NotBlank(message = "Введите описание")
    @Size(max = 100, message = "Не более 100 символов")
    private String description;

    @NotNull(message = "Введите максимальное количество участников")
    @Min(value = 2, message = "От 2-ух участников")
    @Max(value = 64, message = "До 64 участников")
    private Integer maxParticipants;

    @NotNull(message = "Введите количество участников")
    @Min(value = 2, message = "От 2-ух участников")
    @Max(value = 64, message = "До 64 участников")
    private Integer participantCount;

    @NotNull(message = "Введите призовой фонд")
    @Min(value = 1000, message = "От 1000 рублей")
    @Max(value = 100000000, message = "До 100000000 рублей")
    private Integer prizeFund;

    private LocalDateTime dateTime;

    @NotBlank(message = "Введите место проведения")
    @Size(max = 100, message = "Не более 100 символов")
    private String location;

    @NotBlank(message = "Введите формат турнира")
    @Size(max = 100, message = "Не более 100 символов")
    private String format;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public Integer getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(Integer prizeFund) {
        this.prizeFund = prizeFund;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
