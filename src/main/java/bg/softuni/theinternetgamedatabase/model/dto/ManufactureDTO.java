package bg.softuni.theinternetgamedatabase.model.dto;

public class ManufactureDTO {

    private Long id;
    private String companyName;

    public ManufactureDTO() {
    }

    public ManufactureDTO(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public ManufactureDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ManufactureDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
}
