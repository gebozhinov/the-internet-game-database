package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.dto.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "SELECT g.id, g.img_url, g.title, g.rating FROM users u " +
            "JOIN users_favorite_games fg on u.id = fg.user_id " +
            "JOIN games g on fg.game_id = g.id " +
            "WHERE u.id = :id " +
            "ORDER BY g.rating desc",nativeQuery = true)
    Optional<List<TopRatedGamesView>> getTopRatedGames(Long id);
}
