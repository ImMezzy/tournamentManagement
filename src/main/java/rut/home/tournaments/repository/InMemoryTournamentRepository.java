package rut.home.tournaments.repository;

import org.springframework.stereotype.Repository;
import rut.home.tournaments.model.Tournament;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTournamentRepository implements TournamentRepository {

    private final List<Tournament> tournaments = new ArrayList<>(List.of(
            new Tournament(
                    "UNO Open Cup",
                    "Открытый турнир для начинающих и опытных игроков. Матчи проходят по классическим правилам UNO.",
                    32,
                    24,
                    30000,
                    LocalDateTime.of(2026, 11, 15, 12, 0),
                    "Москва, игровой клуб «Точка»",
                    "На выбывание"
            ),
            new Tournament(
                    "Городской чемпионат UNO",
                    "Однодневный чемпионат с групповым этапом и финальной серией для лучших участников.",
                    64,
                    48,
                    75000,
                    LocalDateTime.of(2026, 11, 29, 10, 0),
                    "Москва, молодёжный центр «Смена»",
                    "На выбывание"
            ),
            new Tournament(
                    "Студенческая лига UNO",
                    "Вечерний турнир для студентов. Победитель получает кубок лиги и денежный приз.",
                    16,
                    16,
                    15000,
                    LocalDateTime.of(2026, 12, 6, 18, 30),
                    "Онлайн",
                    "Круговая система"
            )
    ));

    @Override
    public List<Tournament> findAll() {
        return tournaments;
    }

    @Override
    public Optional<Tournament> findByName(String name) {
        return tournaments.stream()
                .filter(tournament -> tournament.title().equals(name))
                .findFirst();
    }

    @Override
    public boolean existsByName(String name) {
        return tournaments.stream()
                .anyMatch(tournament -> tournament.title().equals(name));
    }

    @Override
    public void add(Tournament tournament) {
        tournaments.add(tournament);
    }
}
