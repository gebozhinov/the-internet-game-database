package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.entity.Role;
import bg.softuni.theinternetgamedatabase.model.entity.User;
import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserDetailServiceTest {

    private AppUserDetailService serviceToTest;
    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new AppUserDetailService(
            mockUserRepository
        );
    }

    @Test
    void testUserNotFoundException() {
        assertThrows(NoSuchElementException.class,() -> serviceToTest.loadUserByUsername("test"));

    }

    @Test
    void testUserFoundException() {
        User testUser = createTestUser();
        when(mockUserRepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getUsername());
        assertNotNull(userDetails);
        assertEquals(testUser.getUsername(), userDetails.getUsername());
        assertEquals(testUser.getPassword(), userDetails.getPassword());
        assertEquals(2, userDetails.getAuthorities().size());
        assertTrue(containsAuthority(userDetails, UserRole.USER.name()));
        assertTrue(containsAuthority(userDetails, UserRole.ADMIN.name()));
    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
      return  userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(expectedAuthority));

    }

    private User createTestUser() {
        return new User()
                .setUsername("test")
                .setPassword("test")
                .setEmail("test@test.com")
                .setAge(25)
                .setRoles(Set.of(
                        new Role().setUserRole(UserRole.USER),
                        new Role().setUserRole(UserRole.ADMIN)
                ));
    }
}
