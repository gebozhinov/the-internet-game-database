package bg.softuni.theinternetgamedatabase.model.mapper;

import bg.softuni.theinternetgamedatabase.model.dto.AddGameDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(target = "imgUrl", ignore = true)
    Game addGameDtoToGame(AddGameDTO addGameDTO);
}
