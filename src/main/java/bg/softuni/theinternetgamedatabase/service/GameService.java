package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.view.GameView;
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

    public List<GameView> getAllGames() {
        return this.gameRepository.getAllGames().orElse(new ArrayList<>());
    }

    public List<GameView> getOnFocusGames() {
        return this.gameRepository.getOnFocusGames().orElse(new ArrayList<>());
    }
    public List<TopRatedGamesView> getTopRatedGames() {
        return this.gameRepository.getTopRatedGames().orElse(new ArrayList<>());
    }

    public List<UpcomingGamesView> getUpcomingGames() {
        return this.gameRepository.getUpcomingGames().orElse(new ArrayList<>());
    }
}
