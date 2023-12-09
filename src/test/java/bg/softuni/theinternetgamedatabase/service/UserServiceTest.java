package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.user.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.user.UsernameDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Role;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import bg.softuni.theinternetgamedatabase.model.mapper.UserMapper;
import bg.softuni.theinternetgamedatabase.model.view.FavoriteGamesView;
import bg.softuni.theinternetgamedatabase.model.view.UsernameUserRoleView;
import bg.softuni.theinternetgamedatabase.repository.RoleRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {
    private UserService userServiceToTest;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userServiceToTest = new UserService(userRepository, roleRepository, userMapper, passwordEncoder);
    }

    @Test
    void testRegisterUser() {

        RegisterUserDTO registerUserDTO = new RegisterUserDTO()
                .setUsername("test user")
                .setEmail("test@test.com")
                .setAge(25)
                .setPassword("test123456")
                .setConfirmPassword("test123456");
        User testUser = new User();
        Role role = new Role().setUserRole(UserRole.USER);

        when(userMapper.registerUserDtoToUser(registerUserDTO))
                .thenReturn(testUser);
        when(passwordEncoder.encode(registerUserDTO.getPassword()))
                .thenReturn("test123456");
        when(roleRepository.findById(1L))
                .thenReturn(Optional.of(role));

        userServiceToTest.register(registerUserDTO);
    }

    @Test
    void testGetFavoriteGames() {

        List<FavoriteGamesView> favoriteGames = getFavoriteGames();

        when(userRepository.getFavoriteGames(1L))
                .thenReturn(Optional.of(favoriteGames));

        List<FavoriteGamesView> testFavoriteGames = userServiceToTest.getFavoriteGames(1L);

        assertEquals(favoriteGames.get(0).getTitle(), testFavoriteGames.get(0).getTitle());
    }

    @Test
    void testFindByUsername() {

        User user = new User();

        when(userRepository.findByUsername("test"))
                .thenReturn(Optional.of(user));

        userServiceToTest.findIdByUsername("test");
    }

    @Test
    void testAddAdminRole() {

        Role role = new Role().setUserRole(UserRole.ADMIN);
        User testUser = new User().setUsername("test").setRoles(new HashSet<>());

        when(roleRepository.findById(3L))
                .thenReturn(Optional.of(role));
        when(userRepository.findByUsername("test"))
                .thenReturn(Optional.of(testUser));


        userServiceToTest.addAdminRole(getUsernameDTO());
    }

    @Test
    void testRemoveAdminRole() {

        List<UsernameUserRoleView> usernameUserRoleView = getUsernameUserRoleView();
        Role role = new Role().setUserRole(UserRole.ADMIN);
        User user = new User().setUsername("test").setRoles(new HashSet<>());
        when(roleRepository.findAllUsernamesWithAdminUserRole())
                .thenReturn(Optional.of(usernameUserRoleView));
        when(roleRepository.findById(3L))
                .thenReturn(Optional.of(role));
        when(userRepository.findByUsername("test"))
                .thenReturn(Optional.of(user));

        userServiceToTest.removeAdminRole();
    }

    private List<FavoriteGamesView> getFavoriteGames() {
        FavoriteGamesView favoriteGamesView = new FavoriteGamesView() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getTitle() {
                return "Game";
            }

            @Override
            public String getImg_Url() {
                return "image.jpg";
            }

            @Override
            public String getDescription() {
                return "description";
            }
        };
        return List.of(favoriteGamesView);
    }

    private List<UsernameUserRoleView> getUsernameUserRoleView() {

        UsernameUserRoleView usernameUserRoleView = new  UsernameUserRoleView() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getUsername() {
                return "test";
            }

            @Override
            public String getUser_Role() {
                return "ADMIN";
            }
        };
        return List.of(usernameUserRoleView);
    }
    private UsernameDTO getUsernameDTO() {
        String[] usernames = {"test"};
        return new UsernameDTO().setUsername(usernames);
    }
}
