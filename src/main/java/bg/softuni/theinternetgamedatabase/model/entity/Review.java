package bg.softuni.theinternetgamedatabase.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String review;
    @Column
    private LocalDate created;
    @ManyToOne
    private User author;
    @ManyToOne
    private Game game;

    public String getReview() {
        return review;
    }

    public Review setReview(String review) {
        this.review = review;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Review setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Review setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Game getGame() {
        return game;
    }

    public Review setGame(Game game) {
        this.game = game;
        return this;
    }

    public Long getId() {
        return id;
    }
}
