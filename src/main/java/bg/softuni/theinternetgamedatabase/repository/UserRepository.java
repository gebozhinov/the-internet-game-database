package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users " +
            "WHERE username = :username",nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM users " +
            "WHERE email = :email",nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT g.id, g.img_url, g.title FROM users u " +
            "JOIN users_favorite_games fg on u.id = fg.user_id " +
            "JOIN games g on fg.game_id = g.id " +
            "WHERE u.id = :id ",nativeQuery = true)
    Optional<List<FavoriteGamesView>> getFavoriteGames(Long id);
}
