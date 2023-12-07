package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.entity.Role;
import bg.softuni.theinternetgamedatabase.model.view.UsernameUserRoleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query(value = "SELECT u.id, u.username, r.user_role FROM users u " +
            "JOIN users_roles ur on u.id = ur.user_id " +
            "JOIN roles r on ur.role_id = r.id", nativeQuery = true)
    Optional<List<UsernameUserRoleView>> findAllUsernamesUserRoles();
    @Query(value = "SELECT u.id, u.username, r.user_role FROM users u " +
            "JOIN users_roles ur on u.id = ur.user_id " +
            "JOIN roles r on ur.role_id = r.id " +
            "WHERE r.user_role = 'ADMIN'", nativeQuery = true)
    Optional<List<UsernameUserRoleView>> findAllUsernamesWithAdminUserRole();

}
