package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.TopRatedGamesView;
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

    public List<TopRatedGamesView> getTopRatedGames(Long id) {
        return this.gameRepository.getTopRatedGames(id).orElse(new ArrayList<>()).stream().limit(10L).toList();
    }
}
