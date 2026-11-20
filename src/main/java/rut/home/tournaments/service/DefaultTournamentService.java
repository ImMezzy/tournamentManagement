package rut.home.tournaments.service;

import org.springframework.stereotype.Service;
import rut.home.tournaments.dto.AddTournamentDto;
import rut.home.tournaments.model.Tournament;
import rut.home.tournaments.repository.TournamentRepository;
import rut.home.tournaments.service.exceptions.TournamentNotFoundException;

import java.util.List;

@Service
public class DefaultTournamentService implements TournamentService {

    private final TournamentRepository tournamentRepository;

    public DefaultTournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament getTournamentByName(String name) {
        return tournamentRepository.findByName(name)
                .orElseThrow(() -> new TournamentNotFoundException(name));
    }

    @Override
    public void addTournament(AddTournamentDto source) {
        String normalizedName = source.getTitle().trim();
        if (tournamentRepository.existsByName(normalizedName)) {
            throw new IllegalArgumentException(
                    "Турнир с таким именем уже существует"
            );
        }

        tournamentRepository.add(new Tournament(
                normalizedName,
                source.getDescription(),
                source.getMaxParticipants(),
                source.getParticipantCount(),
                source.getPrizeFund(),
                source.getDateTime(),
                source.getLocation(),
                source.getFormat()
        ));
    }
}
