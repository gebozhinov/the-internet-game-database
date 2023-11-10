package bg.softuni.theinternetgamedatabase.model.entity;

import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public Role setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public Long getId() {
        return id;
    }
}
