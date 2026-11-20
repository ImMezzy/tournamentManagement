package rut.home.tournaments.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rut.home.tournaments.dto.AddTournamentDto;
import rut.home.tournaments.service.TournamentService;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @ModelAttribute("tournamentModel")
    public AddTournamentDto tournamentForm() {
        return new AddTournamentDto();
    }

    @GetMapping("/add")
    public String addTournamentForm(Model model) {
        model.addAttribute("editing", false);
        model.addAttribute("formHeading", "Новый турнир");
        model.addAttribute("submitLabel", "Создать турнир");
        return "tournament-add";
    }

    @PostMapping
    public String addTournament(
            @Valid @ModelAttribute("tournamentModel") AddTournamentDto tournamentModel,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editing", false);
            model.addAttribute("formHeading", "Новый турнир");
            model.addAttribute("submitLabel", "Создать турнир");
            return "tournament-add";
        }

        try {
            tournamentService.addTournament(tournamentModel);
        } catch (IllegalArgumentException exception) {
            bindingResult.rejectValue(
                    "title", "duplicate", exception.getMessage()
            );
            model.addAttribute("editing", false);
            model.addAttribute("formHeading", "Новый турнир");
            model.addAttribute("submitLabel", "Создать турнир");
            return "tournament-add";
        }

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Турнир '" + tournamentModel.getTitle() + "' успешно добавлен"
        );
        return "redirect:/tournaments";
    }


    @GetMapping
    public String showAllTournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        return "tournaments-all";
    }

    @GetMapping("/details")
    public String showTournament(
            @RequestParam String name,
            Model model
    ) {
        model.addAttribute(
                "tournament",
                tournamentService.getTournamentByName(name)
        );
        return "tournament";
    }
}
