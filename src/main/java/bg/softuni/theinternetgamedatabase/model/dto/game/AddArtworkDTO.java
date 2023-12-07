package bg.softuni.theinternetgamedatabase.model.dto.game;

import org.springframework.web.multipart.MultipartFile;

public class AddArtworkDTO {

   private MultipartFile artwork;

    public MultipartFile getArtwork() {
        return artwork;
    }

    public AddArtworkDTO setArtwork(MultipartFile artwork) {
        this.artwork = artwork;
        return this;
    }
}
