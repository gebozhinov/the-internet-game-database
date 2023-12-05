package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.ReviewDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Review;
import bg.softuni.theinternetgamedatabase.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/game/{id}/add-review")
    public String add(@PathVariable Long id, Principal principal, ReviewDTO reviewDTO) {


        this.reviewService.addReview(id, principal.getName(), reviewDTO);


        return "redirect:/game/" + id;
    }

    @PostMapping("/game/{id}/delete-review/{reviewId}/{reviewAuthor}")
    public String delete(@PathVariable Long id, @PathVariable Long reviewId, @PathVariable String reviewAuthor) {

        this.reviewService.deleteReview(id, reviewId, reviewAuthor);

        return "redirect:/game/" + id;
    }
}
