package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.dto.ReviewDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT NEW bg.softuni.theinternetgamedatabase.model.dto.ReviewDTO(r.id, r.review, r.created, r.author.username, r.game.id) " +
            "FROM Review r " +
            "WHERE r.game.id = :id")
    Optional<List<ReviewDTO>> findAllByGameId(Long id);
}
