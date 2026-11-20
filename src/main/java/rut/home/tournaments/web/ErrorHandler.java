package rut.home.tournaments.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import rut.home.tournaments.service.exceptions.TournamentNotFoundException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(TournamentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tournamentNotFound(TournamentNotFoundException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error/tournament-not-found";
    }
}
