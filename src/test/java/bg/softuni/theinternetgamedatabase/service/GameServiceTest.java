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
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import bg.softuni.theinternetgamedatabase.repository.PlatformRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class GameServiceTest {
    private GameService serviceToTest;
    @Mock
    private GameRepository gameRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ManufactureRepository manufactureRepository;
    @Mock
    private PlatformRepository platformRepository;
    @Mock
    private ImageCloudService imageCloudService;
    @Mock
    private GameMapper gameMapper;
    @Mock
    private final Map<Long, Long> views = new HashMap<>();

    @BeforeEach
    void setUp() {
        serviceToTest = new GameService(
                gameRepository, userRepository, manufactureRepository, platformRepository, imageCloudService, gameMapper
        );
    }

    @Test
    void testAdd() {
        AddGameDTO testAddGameDTO = getTestAddGameDTO();
        Manufacture testManufacture = new Manufacture();
        Platform testPlatform = new Platform();
        Principal principal = getPrincipal();
        when(manufactureRepository.findById(1L))
                .thenReturn(Optional.of(testManufacture));
        when(platformRepository.findById(1L))
                .thenReturn(Optional.of(testPlatform));

        Game game = new Game();
        when(gameMapper.addGameDtoToGame(testAddGameDTO))
                .thenReturn(game);

        serviceToTest.add(testAddGameDTO, principal);
    }
    @Test
    void testAddArtwork() {
        Game testGame = getTestGame();
        AddArtworkDTO testAddArtworkDTO = getTestAddArtworkDTO();

        Principal principal = getPrincipal();
        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));

        when(imageCloudService.saveImage(testAddArtworkDTO.getArtwork(), principal))
                .thenReturn("testUrl");

        serviceToTest.addArtwork(testAddArtworkDTO, 1L, principal);
    }

    @Test
    void testGetAllGames() {

        List<GameView> games = getGames();

        when(gameRepository.getAllGames())
                .thenReturn(Optional.of(games));

        List<GameView> allGames = serviceToTest.getAllGames();
        assertEquals(games.size(), allGames.size());
  }


  @Test
  void testOnFocus() {
         List<GameView> games = getGames();
        when(gameRepository.getOnFocusGames())
                .thenReturn(Optional.of(games));
        List<GameView> onFocusGames = serviceToTest.getOnFocusGames();
        assertEquals(games.size(), onFocusGames.size());
  }
  @Test
  void testTopRatedGames() {
        List<TopRatedGamesView> topRatedGames = getTopRatedGames();
        when(gameRepository.getTopRatedGames())
                .thenReturn(Optional.of(topRatedGames));
        List<TopRatedGamesView> testTopRatedGames = serviceToTest.getTopRatedGames();
        assertEquals(topRatedGames.size(), testTopRatedGames.size());
  }

  @Test
  void testAddToFavorites() {
      Game game = getTestGame();
      User user = getTestUser();
      Principal principal = getPrincipal();
      when(gameRepository.findById(1L))
              .thenReturn(Optional.of(game));
        when(userRepository.findByUsername("test"))
              .thenReturn(Optional.of(user));

        serviceToTest.addToFavorites(principal, 1L);
  }

  @Test
  void testRemoveFromFavorites() {
      Game testGame = getTestGame();
      User testUser = getTestUser();
      Principal principal = getPrincipal();
      when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));
      when(userRepository.findByUsername("test"))
              .thenReturn(Optional.of(testUser));

      serviceToTest.removeFromFavorites(principal, 1L);
  }

  @Test
  void testIsInFavorites() {
      Game testGame = getTestGame();
      User testUser = getTestUser();
      Principal principal = getPrincipal();
      when(gameRepository.findById(1L))
              .thenReturn(Optional.of(testGame));
      when(userRepository.findByUsername("test"))
              .thenReturn(Optional.of(testUser));

      serviceToTest.isInFavorites(1L, principal);

      testGame.getUserFavorites().add(testUser);
      testUser.getFavoriteGames().add(testGame);
      serviceToTest.isInFavorites(1L, principal);

  }

    @Test
    void testAddOnFocus() {
        Game testGame = getTestGame();
        testGame.setOnFocus(true);
        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));

        serviceToTest.addOnFocus(1L);

        assertTrue(testGame.isOnFocus());
    }
    @Test
    void testRemoveFromFocus() {
        Game testGame = getTestGame();
        testGame.setOnFocus(false);
        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));

        serviceToTest.removeFromFocus(1L);

        assertFalse(testGame.isOnFocus());
    }

    @Test
    void testIsInFocus() {
        Game testGame = getTestGame();
        testGame.setOnFocus(true);
        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));
        assertTrue(serviceToTest.isOnFocus(1L));

        testGame.setOnFocus(false);
        assertFalse(serviceToTest.isOnFocus(1L));
    }

    @Test
    void testFindArtworkByGameId() {
        List<ArtworkView> testArtworks = findAllArtworkByGameId();
        when(gameRepository.findAllArtworkByGameId(1L))
                .thenReturn(Optional.of(testArtworks));
        serviceToTest.findAllArtworkByGameId(1L);
    }

    @Test
    void testIncrementViews() {
        views.put(1L, 10L);

        serviceToTest.incrementViews(1L);
    }
    @Test
    void testClearViews() {
        views.put(1L, 1L);
        serviceToTest.clearViews();
    }

    private AddArtworkDTO getTestAddArtworkDTO() {
        MockMultipartFile file = new MockMultipartFile("test", "test".getBytes());
        return new AddArtworkDTO()
                .setArtwork(file);
    }
    private AddGameDTO getTestAddGameDTO() {
        String[] genre = {"ADVENTURE"};
        Long[] platforms = {1L};
        MockMultipartFile file = new MockMultipartFile("test", "test".getBytes());

        return new AddGameDTO()
                .setDescription("testDesc")
                .setGenre(genre)
                .setImage(file)
                .setRating(BigDecimal.TEN)
                .setTitle("test")
                .setManufactureId(1L)
                .setPlatformId(platforms)
                .setReleaseDate(LocalDate.now());
    }
    private User getTestUser() {
        return new User()
                .setFavoriteGames(new HashSet<>())
                .setRoles(new HashSet<>())
                .setReviews(new HashSet<>());
    }

    private Game getTestGame() {
        return new Game()
                .setGenres(new HashSet<>())
                .setPlatform(new HashSet<>())
                .setReviews(new HashSet<>())
                .setArtworkUrl(new ArrayList<>())
                .setUserFavorites(new HashSet<>());
    }
    private Principal getPrincipal() {
        return () -> "test";
  }

    private List<GameView> getGames() {
        GameView gameView = new GameView() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getTitle() {
                return "test";
            }

            @Override
            public String getImg_Url() {
                return "testUrl";
            }

            @Override
            public String getDescription() {
                return "description";
            }
        };
        return List.of(gameView);
  }

  private List<TopRatedGamesView> getTopRatedGames() {
        TopRatedGamesView topRatedGamesView = new TopRatedGamesView() {
            @Override
            public Double getRating() {
                return 10.0;
            }

            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getTitle() {
                return "test";
            }

            @Override
            public String getImg_Url() {
                return "testUrl";
            }

            @Override
            public String getDescription() {
                return "description";
            }
        };

        return List.of(topRatedGamesView);
  }

    private List<UpcomingGamesView> getUpcomingGames() {
        UpcomingGamesView upcomingGamesView = new UpcomingGamesView() {
            @Override
            public LocalDate getRelease_Date() {
                return LocalDate.now();
            }

            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getTitle() {
                return "test";
            }

            @Override
            public String getImg_Url() {
                return "testUrl";
            }

            @Override
            public String getDescription() {
                return "description";
            }
        };

        return List.of(upcomingGamesView);
    }

    private List<ArtworkView> findAllArtworkByGameId() {
        ArtworkView artworkView = new ArtworkView() {
            @Override
            public String getArtwork() {
                return "testArtwork";
            }
        };
        return List.of(artworkView);
    }
}
