package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.mapper.UserMapper;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public void register(RegisterUserDTO registerUserDTO) {

        User user = this.userMapper.registerUserDtoToUser(registerUserDTO);


    }
}
