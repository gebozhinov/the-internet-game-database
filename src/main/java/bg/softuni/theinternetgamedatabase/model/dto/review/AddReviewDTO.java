package bg.softuni.theinternetgamedatabase.model.dto.review;

import java.time.LocalDate;

public class AddReviewDTO {

    private String review;
    private LocalDate created;

    public String getDescription() {
        return review;
    }

    public AddReviewDTO setDescription(String review) {
        this.review = review;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddReviewDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }
}
