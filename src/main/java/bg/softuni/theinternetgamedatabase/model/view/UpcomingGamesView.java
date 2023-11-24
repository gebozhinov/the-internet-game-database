package bg.softuni.theinternetgamedatabase.model.view;

import java.time.LocalDate;

public interface UpcomingGamesView extends FavoriteGamesView {
    LocalDate getRelease_Date();
}
