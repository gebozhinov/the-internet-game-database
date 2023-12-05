package bg.softuni.theinternetgamedatabase.model.validation;

import bg.softuni.theinternetgamedatabase.repository.GameRepository;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import bg.softuni.theinternetgamedatabase.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData, String> {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ManufactureRepository manufactureRepository;
    private String fieldName;

    public UniqueDataValidator(UserRepository userRepository,
                               GameRepository gameRepository,
                               ManufactureRepository manufactureRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    public void initialize(UniqueData constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

       return switch (fieldName) {
            case "username" -> this.userRepository.findByUsername(value).isEmpty();
            case "email" -> this.userRepository.findByEmail(value).isEmpty();
            case "title" -> this.gameRepository.findByTitle(value).isEmpty();
            case "companyName" -> this.manufactureRepository.findByManufactureName(value).isEmpty();
            default -> false;
        };

    }
}
