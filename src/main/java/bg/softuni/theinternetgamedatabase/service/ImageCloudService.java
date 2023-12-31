package bg.softuni.theinternetgamedatabase.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static bg.softuni.theinternetgamedatabase.config.CloudinaryConfig.*;

@Service
public class ImageCloudService {

    private Cloudinary cloudinary;

    public ImageCloudService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET
        ));

    }

    public String saveImage(MultipartFile multipartFile, Principal principal) {
        String imageId =  UUID.randomUUID().toString();
        var params = ObjectUtils.asMap(
                "public_id", "igdb/" + principal.getName() + "/" + imageId,
                "overwrite", true,
                "resource_type", "image"
        );

        File tempFile = new File(imageId);

        try {
            Files.write(tempFile.toPath(), multipartFile.getBytes());
            cloudinary.uploader().upload(tempFile, params);
            Files.delete(tempFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("https://res.cloudinary.com/dinjk0zq4/image/upload/igdb/" + principal.getName() + "/" +
                imageId + "." + getFileExtension(Objects.requireNonNull(multipartFile.getOriginalFilename())));
    }
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
