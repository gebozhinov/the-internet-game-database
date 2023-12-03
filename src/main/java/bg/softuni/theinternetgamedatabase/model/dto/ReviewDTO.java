package bg.softuni.theinternetgamedatabase.model.dto;

import java.time.LocalDate;

public class ReviewDTO {
    private Long id;
    private String review;
    private LocalDate created;
    private String authorUsername;
    private Long gameId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String review, LocalDate created, String authorUsername, Long gameId) {
        this.id = id;
        this.review = review;
        this.created = created;
        this.authorUsername = authorUsername;
        this.gameId = gameId;
    }

    public Long getId() {
        return id;
    }

    public ReviewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReview() {
        return review;
    }

    public ReviewDTO setReview(String review) {
        this.review = review;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ReviewDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public ReviewDTO setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
        return this;
    }

    public Long getGameId() {
        return gameId;
    }

    public ReviewDTO setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }
}
