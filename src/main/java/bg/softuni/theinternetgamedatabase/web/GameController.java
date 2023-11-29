package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.dto.PlatformDTO;
import bg.softuni.theinternetgamedatabase.model.view.GameView;
import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import bg.softuni.theinternetgamedatabase.service.GameService;
import bg.softuni.theinternetgamedatabase.service.ManufactureService;
import bg.softuni.theinternetgamedatabase.service.PlatformService;
import bg.softuni.theinternetgamedatabase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final UserService userService;
    private final ManufactureService manufactureService;
    private final PlatformService platformService;
    public GameController(GameService gameService,
                          UserService userService,
                          ManufactureService manufactureService,
                          PlatformService platformService) {
        this.gameService = gameService;
        this.userService = userService;
        this.manufactureService = manufactureService;
        this.platformService = platformService;
    }

    @GetMapping("/{id}")
    public String getGameDetails(@PathVariable("id") Long id) {

        return "game-details";
    }

    @GetMapping("/all")
    public String all(Model model) {

        List<GameView> allGames = this.gameService.getAllGames();

        model.addAttribute("allGames", allGames);


        return "game-all";
    }

    @GetMapping("/favorites")
    public String favorites(Principal principal, Model model) {

        Long id = this.userService.findIdByUsername(principal.getName());

        List<FavoriteGamesView> favoriteGames = this.userService.getFavoriteGames(id);

        model.addAttribute("favoriteGames", favoriteGames);

        return "game-favorites";
    }

    @GetMapping("/top-rated")
    public String topRated(Model model) {

        List<TopRatedGamesView> topRatedGames = this.gameService.getTopRatedGames();

        model.addAttribute("topRatedGames", topRatedGames);

        return "game-top-rated";
    }

    @GetMapping("/coming-soon")
    public String comingSoon(Model model) {

        List<UpcomingGamesView> upcomingGames = this.gameService.getUpcomingGames();

        model.addAttribute("upcomingGames", upcomingGames);

        return "game-coming-soon";
    }

    @GetMapping("/add")
    public String add(Model model) {

        List<ManufactureDTO> manufacturesData = this.manufactureService.getManufacturesData();
        model.addAttribute("manufacturesData", manufacturesData);

        List<PlatformDTO> platformData = this.platformService.getPlatformData();
        model.addAttribute("platformData", platformData);

        return "game-add";
    }

}
