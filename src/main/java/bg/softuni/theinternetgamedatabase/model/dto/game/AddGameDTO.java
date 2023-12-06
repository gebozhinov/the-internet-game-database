package bg.softuni.theinternetgamedatabase.model.dto.game;

import bg.softuni.theinternetgamedatabase.model.validation.UniqueData;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDTO {

    @Size(message = "Title cannot be empty.")
    @NotBlank(message = "Title cannot be empty.")
    @UniqueData(fieldName = "title", message = "The game is already registered.")
    private String title;

    private MultipartFile image;
    @Positive(message = "Select manufacture.")
    @NotNull(message = "Select manufacture.")
    private Long manufactureId;
    @NotEmpty(message = "Select genre/es.")
    private String[] genre;
    @NotEmpty(message = "Select platform/s.")
    private Long[] platformId;
    private LocalDate releaseDate;
    private String description;
    @DecimalMin(value = "0", message = "Rating should be positive.")
    @DecimalMax(value = "10", message = "Rating should be max 10.")
    private BigDecimal rating;

    public String getTitle() {
        return title;
    }

    public AddGameDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public AddGameDTO setImage(MultipartFile image) {
        this.image = image;
        return this;
    }

    public Long getManufactureId() {
        return manufactureId;
    }

    public AddGameDTO setManufactureId(Long manufactureId) {
        this.manufactureId = manufactureId;
        return this;
    }

    public String[] getGenre() {
        return genre;
    }

    public AddGameDTO setGenre(String[] genre) {
        this.genre = genre;
        return this;
    }

    public Long[] getPlatformId() {
        return platformId;
    }

    public AddGameDTO setPlatformId(Long[] platformId) {
        this.platformId = platformId;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddGameDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddGameDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public AddGameDTO setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }
}
