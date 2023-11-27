package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.view.AllGamesView;
import bg.softuni.theinternetgamedatabase.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public String all(Model model) {

        List<AllGamesView> allGames = this.gameService.getAllGames();

        model.addAttribute("allGames", allGames);


        return "game-all";
    }

}
