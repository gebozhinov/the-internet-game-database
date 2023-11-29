package bg.softuni.theinternetgamedatabase.model.dto;

public class PlatformDTO {

    private Long id;
    private String name;


    public PlatformDTO() {
    }

    public PlatformDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public PlatformDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlatformDTO setName(String name) {
        this.name = name;
        return this;
    }
}
