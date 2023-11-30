package bg.softuni.theinternetgamedatabase.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class GameDTO {

    private String title;
    private MultipartFile imgUrl;
    private Long manufactureId;
    private int[] genre;
    private Long[] platformId;
    private LocalDate releaseDate;
    private String description;
    private Double rating;

    public String getTitle() {
        return title;
    }

    public GameDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public MultipartFile getImgUrl() {
        return imgUrl;
    }

    public GameDTO setImgUrl(MultipartFile imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Long getManufactureId() {
        return manufactureId;
    }

    public GameDTO setManufactureId(Long manufactureId) {
        this.manufactureId = manufactureId;
        return this;
    }

    public int[] getGenre() {
        return genre;
    }

    public GameDTO setGenre(int[] genre) {
        this.genre = genre;
        return this;
    }

    public Long[] getPlatformId() {
        return platformId;
    }

    public GameDTO setPlatformId(Long[] platformId) {
        this.platformId = platformId;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public GameDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GameDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public GameDTO setRating(Double rating) {
        this.rating = rating;
        return this;
    }
}
