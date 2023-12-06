package bg.softuni.theinternetgamedatabase.service;


import bg.softuni.theinternetgamedatabase.model.dto.user.UsernameDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Role;
import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.dto.user.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.mapper.UserMapper;
import bg.softuni.theinternetgamedatabase.repository.RoleRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       UserMapper userMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(RegisterUserDTO registerUserDTO) {

        User user = this.userMapper.registerUserDtoToUser(registerUserDTO)
                .setPassword(this.passwordEncoder.encode(registerUserDTO.getPassword()))
                .setRoles(Set.of(this.roleRepository.findById(1L).get()));

        this.userRepository.save(user);
    }

    public List<FavoriteGamesView> getFavoriteGames(Long id) {
      return this.userRepository.getFavoriteGames(id).orElse(new ArrayList<>());
    }

    public Long findIdByUsername(String username) {
      return this.userRepository.findByUsername(username).get().getId();
    }


    public void addAdminRole(UsernameDTO UsernameDTO) {

        for (String username : UsernameDTO.getUsername()) {
            User user = this.userRepository.findByUsername(username).get();
            Role role = this.roleRepository.findById(3L).get();
            user.getRoles().add(role);
            this.userRepository.save(user);
        }
    }
}
