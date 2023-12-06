package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.review.ReviewDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.entity.Review;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.mapper.ReviewMapper;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ReviewRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository,
                         GameRepository gameRepository,
                         UserRepository userRepository,
                         ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> findAllByGameId(Long id) {

      return   this.reviewRepository.findAllByGameId(id).orElse(new ArrayList<>());
    }

    public void addReview(Long id, String username, ReviewDTO reviewDTO) {

        Game game = this.gameRepository.findById(id).get();
        User user = this.userRepository.findByUsername(username).get();
        Review review = this.reviewMapper.reviewDtoToReview(reviewDTO)
                .setCreated(LocalDate.now())
                .setAuthor(user)
                .setGame(game);

        this.reviewRepository.save(review);
        this.gameRepository.save(game);
        this.userRepository.save(user);

    }

    public void deleteReview(Long gameId, Long reviewId, String username) {

        Game game = this.gameRepository.findById(gameId).get();
        Review review = this.reviewRepository.findById(reviewId).get();
        User user = this.userRepository.findByUsername(username).get();

        game.getReviews().remove(review);
        user.getReviews().remove(review);
        this.reviewRepository.delete(review);

    }
}
