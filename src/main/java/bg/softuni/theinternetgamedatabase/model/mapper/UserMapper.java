package bg.softuni.theinternetgamedatabase.model.mapper;

import bg.softuni.theinternetgamedatabase.model.dto.EditUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    User registerUserDtoToUser(RegisterUserDTO registerUserDTO);
    @Mapping(target = "password", ignore = true)
    EditUserDTO userToEditUserDto(User user);
}
