package bg.softuni.theinternetgamedatabase.model.dto;

public class UserDTO {
    private Long id;
    private String username;

    private String url;

    public UserDTO(Long id, String username) {
        this.url = "http://localhost:8080/users/edit/" + id;
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UserDTO setUrl(String url) {
        this.url = url;
        return this;
    }
}
