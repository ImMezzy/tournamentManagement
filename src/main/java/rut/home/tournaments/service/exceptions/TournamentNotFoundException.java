package rut.home.tournaments.service.exceptions;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException(String name) {
        super("Турнир с названием «" + name + "» не найден");
    }
}
