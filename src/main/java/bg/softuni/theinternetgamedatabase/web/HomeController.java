package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.dto.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.service.GameService;
import bg.softuni.theinternetgamedatabase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final GameService gameService;

    public HomeController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String home(Principal principal, Model model) {
        Long userId = this.userService.findById(principal.getName());

        List<FavoriteGamesView> favoriteGames = this.userService.getFavoriteGames(userId);
        model.addAttribute("favoriteGames", favoriteGames);

        List<TopRatedGamesView> topRatedGames = this.gameService.getTopRatedGames(userId);
        model.addAttribute("topRatedGames", topRatedGames);

        return "index";
    }
}
