package bg.softuni.theinternetgamedatabase.model.entity;

import bg.softuni.theinternetgamedatabase.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Role role)) return false;
        return Objects.equals(getId(), role.getId()) && getUserRole() == role.getUserRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserRole());
    }
}
