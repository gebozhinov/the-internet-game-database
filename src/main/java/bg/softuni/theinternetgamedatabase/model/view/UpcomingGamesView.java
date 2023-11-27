package bg.softuni.theinternetgamedatabase.model.view;

import java.time.LocalDate;

public interface UpcomingGamesView extends AllGamesView {
    LocalDate getRelease_Date();
}
