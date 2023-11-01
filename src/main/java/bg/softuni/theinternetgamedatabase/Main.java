package bg.softuni.theinternetgamedatabase;

import bg.softuni.theinternetgamedatabase.model.entity.Game;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import bg.softuni.theinternetgamedatabase.model.enums.GameGenre;
import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Main implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final ManufactureRepository manufactureRepository;

    public Main(GameRepository gameRepository,
                ManufactureRepository manufactureRepository) {
        this.gameRepository = gameRepository;
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        Game game = new Game();
//        game.setTitle("GTA");
//
//        Manufacture manufacture = new Manufacture().setCompanyName("Rockstar");
//
//        game.setManufacture(manufacture);
//
//        game.setGenres(Set.of(GameGenre.ADVENTURE, GameGenre.RPG, GameGenre.SHOOTER));
//        manufacture.setGames(Set.of(game));
//
//        this.gameRepository.save(game);
//        this.manufactureRepository.save(manufacture);

    }
}
