package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Principal principal, Model model) {
        Long userId = this.userService.findById(principal.getName());
        List<FavoriteGamesView> favoriteGames = this.userService.getFavoriteGames(userId);
        model.addAttribute("favoriteGames", favoriteGames);

        return "index";
    }
}
