package bg.softuni.theinternetgamedatabase;

import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main implements CommandLineRunner {


    private final UserRepository userRepository;

    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User user = this.userRepository.findById(1L).get();
        List<FavoriteGamesView> games = userRepository.getFavoriteGames(1L).get();
        String description = games.get(1).getTitle();
        System.out.println();

    }
}
