package bg.softuni.theinternetgamedatabase.model.mapper;

import bg.softuni.theinternetgamedatabase.model.dto.ReviewDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review reviewDtoToReview(ReviewDTO reviewDTO);
}
