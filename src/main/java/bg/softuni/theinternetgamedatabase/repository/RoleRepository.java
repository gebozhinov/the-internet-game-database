package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.entity.Role;
import bg.softuni.theinternetgamedatabase.model.view.UserUsernameView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query(value = "SELECT u.username FROM users u " +
            "JOIN users_roles ur on u.id = ur.user_id " +
            "JOIN roles r on ur.role_id = r.id " +
            "WHERE r.user_role = 'ADMIN'", nativeQuery = true)
    Optional<List<UserUsernameView>> findAllUsernamesByUserRoleAdmin();
    @Query(value = "SELECT u.username FROM users u " +
            "JOIN users_roles ur on u.id = ur.user_id " +
            "JOIN roles r on ur.role_id = r.id " +
            "WHERE r.user_role = 'MODERATOR'", nativeQuery = true)
    Optional<List<UserUsernameView>> findAllUsernamesByUserRoleModerator();
    @Query(value = "SELECT u.username FROM users u " +
            "JOIN users_roles ur on u.id = ur.user_id " +
            "JOIN roles r on ur.role_id = r.id " +
            "WHERE r.user_role = 'USER'", nativeQuery = true)
    Optional<List<UserUsernameView>> findAllUsernamesByUserRoleUser();
}
