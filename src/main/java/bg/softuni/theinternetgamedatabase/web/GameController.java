package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.view.AllGamesView;
import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.service.GameService;
import bg.softuni.theinternetgamedatabase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final UserService userService;

    public GameController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String all(Model model) {

        List<AllGamesView> allGames = this.gameService.getAllGames();

        model.addAttribute("allGames", allGames);


        return "game-all";
    }

    @GetMapping("/favorites")
    public String favorites(Principal principal, Model model) {

        Long id = this.userService.findIdByUsername(principal.getName());

        List<FavoriteGamesView> favoriteGames = this.userService.getFavoriteGames(id, "");

        model.addAttribute("favoriteGames", favoriteGames);

        return "game-favorites";
    }

}
