package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.review.ReviewDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.entity.Review;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.mapper.ReviewMapper;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ReviewRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    private ReviewService serviceToTest;
    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private GameRepository gameRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ReviewMapper reviewMapper;

    @BeforeEach
    void setUp() {
        serviceToTest = new ReviewService(
                reviewRepository,
                gameRepository,
                userRepository,
                reviewMapper
        );
    }

    @Test
    void testFindAllByGameId() {
        List<ReviewDTO> reviewDTOs = getReviewDTOs();
        when(reviewRepository.findAllByGameId(1L))
                .thenReturn(Optional.of(reviewDTOs));

        List<ReviewDTO> testAllByGameId = serviceToTest.findAllByGameId(1L);

        assertEquals(reviewDTOs.size(), testAllByGameId.size());
    }

    @Test
    void testAddReview() {
        Game testGame = getTestGame();
        User testUser = getTestUser();
        Review testReview = getTestReview(testGame, testUser);

        ReviewDTO reviewDTO = new ReviewDTO();

        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));
        when(userRepository.findByUsername("test"))
                .thenReturn(Optional.of(testUser));
        when(reviewMapper.reviewDtoToReview(reviewDTO))
                .thenReturn(testReview);

        serviceToTest.addReview(1L, "test", reviewDTO);

    }

    @Test
    void testDeleteReview() {
        Game testGame = getTestGame();
        User testUser = getTestUser();
        Review testReview = getTestReview(testGame, testUser);
        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(testGame));
        when(userRepository.findByUsername("test"))
                .thenReturn(Optional.of(testUser));
        when(reviewRepository.findById(1L))
                .thenReturn(Optional.of(testReview));

        serviceToTest.deleteReview(1L, 1L, "test");
    }

    private Review getTestReview(Game testGame, User testAuthor) {
        return new Review()
                .setCreated(LocalDate.now())
                .setGame(testGame)
                .setAuthor(testAuthor);
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
    private List<ReviewDTO> getReviewDTOs() {
        ReviewDTO reviewDTO = new ReviewDTO()
                .setId(1L)
                .setReview("test")
                .setCreated(LocalDate.now())
                .setGameId(1L)
                .setAuthorUsername("test");

        return List.of(reviewDTO);
    }
}
