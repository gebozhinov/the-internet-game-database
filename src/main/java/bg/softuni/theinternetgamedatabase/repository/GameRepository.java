package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.dto.game.GameDTO;
import bg.softuni.theinternetgamedatabase.model.view.ArtworkView;
import bg.softuni.theinternetgamedatabase.model.view.GameView;
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


    @Query(value = "SELECT g.id, g.img_url, g.title, concat(left(g.description, 255), '...') as description FROM games g",nativeQuery = true)
    Optional<List<GameView>> getAllGames();

    @Query(value = "SELECT g.id, g.img_url, g.title FROM games g " +
            "WHERE g.on_focus = true", nativeQuery = true)
    Optional<List<GameView>> getOnFocusGames();
    @Query(value = "SELECT g.id, g.img_url, g.title, g.rating, concat(left(g.description, 255), '...') as description FROM games g " +
            "WHERE g.rating is not null " +
            "ORDER BY g.rating desc",nativeQuery = true)
    Optional<List<TopRatedGamesView>> getTopRatedGames();

    @Query(value = "SELECT g.id, g.description, g.img_url, g.release_date, g.title, concat(left(g.description, 255), '...') as description FROM games g " +
            "WHERE g.release_date > now() " +
            "ORDER BY g.release_date",nativeQuery = true)
    Optional<List<UpcomingGamesView>> getUpcomingGames();

    @Query(value = "SELECT * FROM games " +
            "WHERE title = :title",nativeQuery = true)
    Optional<Game> findByTitle(String title);

    @Query("SELECT NEW bg.softuni.theinternetgamedatabase.model.dto.game.GameDTO(g.id, g.title, g.description, g.imgUrl, g.rating) " +
            "FROM Game g " +
            "WHERE g.id = :id")
    Optional<GameDTO> findGameById(Long id);

    @Query(value = "SELECT a.artwork FROM games g " +
            "JOIN artwork a on g.id = a.game_id " +
            "WHERE g.id = :id", nativeQuery = true)
    Optional<List<ArtworkView>> findAllArtworkByGameId(Long id);
}
