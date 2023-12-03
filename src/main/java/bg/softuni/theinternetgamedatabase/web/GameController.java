package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.*;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.view.GameView;
import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import bg.softuni.theinternetgamedatabase.service.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final UserService userService;
    private final ManufactureService manufactureService;
    private final ReviewService reviewService;
    private final PlatformService platformService;
    public GameController(GameService gameService,
                          UserService userService,
                          ManufactureService manufactureService,
                          ReviewService reviewService,
                          PlatformService platformService) {
        this.gameService = gameService;
        this.userService = userService;
        this.manufactureService = manufactureService;
        this.reviewService = reviewService;
        this.platformService = platformService;
    }


    @ModelAttribute("addGameDTO")
    public AddGameDTO addGameDTO() {
        return new AddGameDTO();
    }

    @GetMapping("/{id}")
    public String getGameDetails(@PathVariable("id") Long id, Principal principal, Model model) {

        GameDTO gameDTO = this.gameService.findGameById(id);
        model.addAttribute("gameDTO", gameDTO);
        boolean inFavorites = this.gameService.isInFavorites(id, principal);
        model.addAttribute("isInFavorites", inFavorites);
        boolean isOnFocus = this.gameService.isOnFocus(id);
        model.addAttribute("isOnFocus", isOnFocus);

        List<ReviewDTO> reviews = this.reviewService.findAllByGameId(id);
        model.addAttribute("reviews", reviews);

        return "game-details";
    }

    @PostMapping("/{id}/add-to-favorites")
    public String addToFavorites(@PathVariable("id") Long id, Principal principal, Model model) {

        this.gameService.addToFavorites(principal, id);

       return this.getGameDetails(id, principal, model);

    }
    @PostMapping("/{id}/remove-from-favorites")
    public String removeFromFavorites(@PathVariable("id") Long id, Principal principal, Model model) {

        this.gameService.removeFromFavorites(principal, id);

        return this.getGameDetails(id, principal, model);

    }
    @PostMapping("/{id}/add-on-focus")
    public String addOnFocus(@PathVariable("id") Long id, Principal principal, Model model) {

        this.gameService.addOnFocus(id);

        return this.getGameDetails(id, principal, model);

    }
    @PostMapping("/{id}/remove-from-focus")
    public String removeFromFocus(@PathVariable("id") Long id, Principal principal, Model model) {

        this.gameService.removeFromFocus(id);

        return this.getGameDetails(id, principal, model);

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

    @PostMapping("/add")
    public String add(@Valid AddGameDTO addGameDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes, Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addGameDTO", addGameDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addGameDTO",
                    bindingResult);
            return "redirect:/game/add";
        }

        Game game = this.gameService.add(addGameDTO, principal);

        return "redirect:/game/" + game.getId();
    }

}
