package bg.softuni.theinternetgamedatabase.model.dto.manufacture;

import bg.softuni.theinternetgamedatabase.model.validation.UniqueData;
import jakarta.validation.constraints.NotBlank;

public class AddManufactureDTO {
    @UniqueData(fieldName = "companyName", message = "This company is already registered!")
    @NotBlank(message = "Company name should not be empty!")
    String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public AddManufactureDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
}
