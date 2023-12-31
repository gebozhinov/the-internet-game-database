package bg.softuni.theinternetgamedatabase.model.mapper;

import bg.softuni.theinternetgamedatabase.model.dto.user.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    User registerUserDtoToUser(RegisterUserDTO registerUserDTO);

}
