package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.game.AddArtworkDTO;
import bg.softuni.theinternetgamedatabase.model.dto.game.AddGameDTO;
import bg.softuni.theinternetgamedatabase.model.dto.game.GameDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import bg.softuni.theinternetgamedatabase.model.entity.Platform;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.enums.GameGenre;
import bg.softuni.theinternetgamedatabase.model.mapper.GameMapper;
import bg.softuni.theinternetgamedatabase.model.view.ArtworkView;
import bg.softuni.theinternetgamedatabase.model.view.GameView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import bg.softuni.theinternetgamedatabase.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class GameService {


    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final ManufactureRepository manufactureRepository;
    private final PlatformRepository platformRepository;
    private final ImageCloudService imageCloudService;
    private final GameMapper gameMapper;

    public GameService(GameRepository gameRepository,
                       UserRepository userRepository,
                       ManufactureRepository manufactureRepository,
                       PlatformRepository platformRepository,
                       ImageCloudService imageCloudService,
                       GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.manufactureRepository = manufactureRepository;
        this.platformRepository = platformRepository;
        this.imageCloudService = imageCloudService;
        this.gameMapper = gameMapper;
    }

    public GameDTO findGameById(Long id) {
      return  this.gameRepository.findGameById(id).get();
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

    public Game add(AddGameDTO addGameDTO, Principal principal) {

        Game game = this.gameMapper.addGameDtoToGame(addGameDTO);
        game.setManufacture(this.setManufacture(addGameDTO.getManufactureId()));
        game.setGenres(this.setGameGenres(addGameDTO.getGenre()));
        game.setPlatform(this.setPlatform(addGameDTO.getPlatformId()));

        game.setImgUrl(this.imageCloudService.saveImage(addGameDTO.getImage(), principal));

       return this.gameRepository.save(game);

    }

    public void addArtwork(AddArtworkDTO addArtworkDTO, Long id, Principal principal) {
        Game game = this.gameRepository.findById(id).get();
        if (game.getArtworkUrl().isEmpty()) {
            game.setArtworkUrl(new ArrayList<>());
        }

        game.getArtworkUrl().add(this.imageCloudService.saveImage(addArtworkDTO.getArtwork(), principal));

        this.gameRepository.save(game);
    }

    public void addToFavorites(Principal principal, Long id) {

        Game game = this.gameRepository.findById(id).get();

        User user = this.userRepository.findByUsername(principal.getName()).get();
        if (user.getFavoriteGames().isEmpty()) {
            user.setFavoriteGames(new HashSet<>());
        }

        if (game.getUserFavorites().isEmpty()) {
            game.setUserFavorites(new HashSet<>());
        }

        user.getFavoriteGames().add(game);
        game.getUserFavorites().add(user);

        this.userRepository.save(user);
        this.gameRepository.save(game);

    }

    @Transactional
    public void removeFromFavorites(Principal principal, Long id) {
        Game game = this.gameRepository.findById(id).get();
        User user = this.userRepository.findByUsername(principal.getName()).get();

        user.getFavoriteGames().remove(game);
        game.getUserFavorites().remove(user);

        this.userRepository.save(user);
        this.gameRepository.save(game);
    }
    public boolean isInFavorites(Long id, Principal principal) {
        Game game = this.gameRepository.findById(id).get();
        User user = this.userRepository.findByUsername(principal.getName()).get();

        for (Game favoriteGame : user.getFavoriteGames()) {
            if (Objects.equals(favoriteGame.getId(), game.getId())) {
                return true;
            }
        }

        return false;
    }

    public void addOnFocus(Long id) {
        Game game = this.gameRepository.findById(id).get();
        game.setOnFocus(true);
        this.gameRepository.save(game);
    }

    public void removeFromFocus(Long id) {
        Game game = this.gameRepository.findById(id).get();
        game.setOnFocus(false);
        this.gameRepository.save(game);
    }

    public boolean isOnFocus(Long id) {
        return this.gameRepository.findById(id).get().isOnFocus();
    }

    public List<ArtworkView> findAllArtworkByGameId(Long id) {
      return this.gameRepository.findAllArtworkByGameId(id).orElse(new ArrayList<>());
    }
    private Manufacture setManufacture(Long id) {
        return this.manufactureRepository.findById(id).get();
    }
    private Set<Platform> setPlatform(Long[] platformIds) {

        Set<Platform> platforms = new HashSet<>();

        for (Long platformId : platformIds) {
            Platform platform = this.platformRepository.findById(platformId).get();
            platforms.add(platform);
        }

        return platforms;
    }
    private Set<GameGenre> setGameGenres(String[] genre) {

        Set<GameGenre> genres = new HashSet<>();

        for (String s : genre) {
            genres.add(GameGenre.valueOf(s));
        }

        return genres;
    }
}
