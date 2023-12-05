package bg.softuni.theinternetgamedatabase.model.entity;

import bg.softuni.theinternetgamedatabase.model.enums.GameGenre;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(name = "img_url",nullable = false ,unique = true)
    private String imgUrl;
    @ManyToOne
    private Manufacture manufacture;
    @ElementCollection(targetClass = GameGenre.class)
    @CollectionTable(name = "game_genre")
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Set<GameGenre> genres;
    @ManyToMany
    @JoinTable(
            name = "games_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platform;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private BigDecimal rating;
    @Column(name = "on_focus", columnDefinition = "boolean default false")
    private boolean onFocus;
    @OneToMany(targetEntity = Review.class, mappedBy = "game", fetch = FetchType.EAGER)
    private Set<Review> reviews;
    @ManyToMany(targetEntity = User.class, mappedBy = "favoriteGames", fetch = FetchType.EAGER)
    private Set<User> userFavorites;
    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public Game setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
        return this;
    }

    public Set<GameGenre> getGenres() {
        return genres;
    }

    public Game setGenres(Set<GameGenre> genres) {
        this.genres = genres;
        return this;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }

    public Game setPlatform(Set<Platform> platform) {
        this.platform = platform;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Game setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Game setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public Game setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Game setReviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Game setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Set<User> getUserFavorites() {
        return userFavorites;
    }

    public Game setUserFavorites(Set<User> userFavorites) {
        this.userFavorites = userFavorites;
        return this;
    }

    public boolean isOnFocus() {
        return onFocus;
    }

    public Game setOnFocus(boolean onFocus) {
        this.onFocus = onFocus;
        return this;
    }
}
