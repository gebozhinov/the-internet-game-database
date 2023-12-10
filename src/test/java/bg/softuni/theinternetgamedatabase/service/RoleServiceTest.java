package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import bg.softuni.theinternetgamedatabase.model.view.UsernameUserRoleView;
import bg.softuni.theinternetgamedatabase.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    private RoleService serviceToTest;
    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new RoleService(roleRepository);
    }
    
    @Test
    void testFindAllUsernamesByUserRole() {
        List<UsernameUserRoleView> test = getUsernameUserRoleViews();
        when(roleRepository.findAllUsernamesUserRoles())
                .thenReturn(Optional.of(test));


        serviceToTest.findAllUsernamesByUserRole();
    }
    private List<UsernameUserRoleView> getUsernameUserRoleViews() {
        UsernameUserRoleView usernameUserRoleView = new UsernameUserRoleView() {
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
                return UserRole.ADMIN.name();
            }
        };

        return List.of(usernameUserRoleView);
    }
}
