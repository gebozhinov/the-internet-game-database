package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.AddGameDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import bg.softuni.theinternetgamedatabase.model.entity.Platform;
import bg.softuni.theinternetgamedatabase.model.enums.GameGenre;
import bg.softuni.theinternetgamedatabase.model.mapper.GameMapper;
import bg.softuni.theinternetgamedatabase.model.view.GameView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import bg.softuni.theinternetgamedatabase.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GameService {


    private final GameRepository gameRepository;
    private final ManufactureRepository manufactureRepository;
    private final PlatformRepository platformRepository;
    private final GameMapper gameMapper;

    public GameService(GameRepository gameRepository,
                       ManufactureRepository manufactureRepository,
                       PlatformRepository platformRepository,
                       GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.manufactureRepository = manufactureRepository;
        this.platformRepository = platformRepository;
        this.gameMapper = gameMapper;
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

    public void add(AddGameDTO addGameDTO) {

        Game game = this.gameMapper.addGameDtoToGame(addGameDTO);
        game.setManufacture(this.setManufacture(addGameDTO.getManufactureId()));
        game.setGenres(this.setGameGenres(addGameDTO.getGenre()));
        game.setPlatform(this.setPlatform(addGameDTO.getPlatformId()));

    }

    private Manufacture setManufacture(Long id) {
        return this.manufactureRepository.findById(id).get();
    }
    private Set<Platform> setPlatform(Long[] platformIds) {

        Set<Platform> platforms = new HashSet<>();

        for (int i = 0; i < platformIds.length; i++) {
            Platform platform = this.platformRepository.findById(platformIds[i]).get();
            platforms.add(platform);
        }

        return platforms;
    }
    private Set<GameGenre> setGameGenres(String[] genre) {

        Set<GameGenre> genres = new HashSet<>();

        for (int i = 0; i < genre.length; i++) {
            genres.add(GameGenre.valueOf(genre[i]));
        }

        return genres;
    }
}
