package bg.softuni.theinternetgamedatabase.model.entity;

import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public Role setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
