package bg.softuni.theinternetgamedatabase.model.dto;

import java.math.BigDecimal;

public class GameDTO {
    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private BigDecimal rating;

    public GameDTO() {
    }

    public GameDTO(Long id, String title, String description, String imgUrl, BigDecimal rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public GameDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GameDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GameDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public GameDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public GameDTO setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }
}
