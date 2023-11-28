package bg.softuni.theinternetgamedatabase.model.view;

import java.time.LocalDate;

public interface UpcomingGamesView extends GameView {
    LocalDate getRelease_Date();
}
