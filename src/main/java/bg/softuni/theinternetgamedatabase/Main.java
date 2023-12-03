package bg.softuni.theinternetgamedatabase;

import bg.softuni.theinternetgamedatabase.model.dto.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main implements CommandLineRunner {


    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ManufactureRepository manufactureRepository;

    public Main(UserRepository userRepository, GameRepository gameRepository,
                ManufactureRepository manufactureRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        User user = this.userRepository.findById(1L).get();
//        List<FavoriteGamesView> games = userRepository.getFavoriteGames(1L).get();
//        String description = games.get(1).getTitle();

//        List<ManufactureDTO> manufactureDTOS = manufactureRepository.getManufacturesData().get();

        Game game = this.gameRepository.findById(1L).get();

        System.out.println();

    }
}
