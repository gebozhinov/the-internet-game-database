package bg.softuni.theinternetgamedatabase.model.dto;

import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;

public interface FavoriteGamesView {
    Long getId();
    String getTitle();
    String getImgUrl();
    String getDescription();
}
