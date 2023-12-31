package bg.softuni.theinternetgamedatabase.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_favorite_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> favoriteGames;
    @OneToMany(targetEntity = Review.class, mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Review> reviews;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<Game> getFavoriteGames() {
        return favoriteGames;
    }

    public User setFavoriteGames(Set<Game> favoriteGames) {
        this.favoriteGames = favoriteGames;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public User setReviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Long getId() {
        return id;
    }
}
