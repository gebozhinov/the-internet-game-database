package bg.softuni.theinternetgamedatabase.model.entity;

import bg.softuni.theinternetgamedatabase.model.enums.PlatformFamily;
import bg.softuni.theinternetgamedatabase.model.enums.PlatformType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "platforms")
public class Platform extends BaseEntity {

    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "platform_type")
    private PlatformType platformType;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform_family")
    private PlatformFamily platformFamily;

    @ManyToMany(mappedBy = "platform")
    private Set<Game> games;

    public String getName() {
        return name;
    }

    public Platform setName(String name) {
        this.name = name;
        return this;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }

    public Platform setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
        return this;
    }

    public PlatformFamily getPlatformFamily() {
        return platformFamily;
    }

    public Platform setPlatformFamily(PlatformFamily platformFamily) {
        this.platformFamily = platformFamily;
        return this;
    }

    public Set<Game> getGames() {
        return games;
    }

    public Platform setGames(Set<Game> games) {
        this.games = games;
        return this;
    }
}
