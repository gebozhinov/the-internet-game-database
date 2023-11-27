package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.view.AllGamesView;
import bg.softuni.theinternetgamedatabase.model.view.TopRatedGamesView;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.view.UpcomingGamesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


    @Query(value = "SELECT g.id, g.img_url, g.title, concat(left(g.description, 220), '...') as description FROM games g",nativeQuery = true)
    Optional<List<AllGamesView>> getAllGames();

    @Query(value = "SELECT g.id, g.img_url, g.title, g.rating, concat(left(g.description, 220), '...') as description FROM users u " +
            "JOIN users_favorite_games fg on u.id = fg.user_id " +
            "JOIN games g on fg.game_id = g.id " +
            "ORDER BY g.rating desc",nativeQuery = true)
    Optional<List<TopRatedGamesView>> getTopRatedGames();

    @Query(value = "SELECT g.id, g.description, g.img_url, g.release_date, g.title, concat(left(g.description, 220), '...') as description FROM games g " +
            "WHERE g.release_date > now() " +
            "ORDER BY g.release_date",nativeQuery = true)
    Optional<List<UpcomingGamesView>> getUpcomingGames();
}
