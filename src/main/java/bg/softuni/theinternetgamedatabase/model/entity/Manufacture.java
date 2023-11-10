package bg.softuni.theinternetgamedatabase.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "manufactures")
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name", unique = true, nullable = false)
    private String companyName;
    @OneToMany(targetEntity = Game.class, mappedBy = "manufacture")
    private Set<Game> games;

    public String getCompanyName() {
        return companyName;
    }

    public Manufacture setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Set<Game> getGames() {
        return games;
    }

    public Manufacture setGames(Set<Game> games) {
        this.games = games;
        return this;
    }

    public Long getId() {
        return id;
    }
}
