package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.view.AllGamesView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {


    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<AllGamesView> getAllGames() {
        return this.gameRepository.getAllGames().orElse(new ArrayList<>());
    }

    public List<TopRatedGamesView> getTopRatedGames(String page) {

        if (page.equals("home")) {
            return this.gameRepository.getTopRatedGames().orElse(new ArrayList<>()).stream().limit(10L).toList();
        }

        return this.gameRepository.getTopRatedGames().orElse(new ArrayList<>());
    }

    public List<UpcomingGamesView> getUpcomingGames() {
        return this.gameRepository.getUpcomingGames().orElse(new ArrayList<>()).stream().limit(10L).toList();
    }
}
