package bg.softuni.theinternetgamedatabase.model.dto;

import bg.softuni.theinternetgamedatabase.model.validation.UniqueData;
import jakarta.validation.constraints.*;


public class EditUserDTO {
    private Long id;
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 2, max = 20, message = "Username length must be between 2 and 20 characters!")
    private String username;
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email address must be valid!")
    private String email;
    @PositiveOrZero(message = "Age cannot be negative number!")
    @NotNull(message = "Age cannot be empty!")
    private Integer age;
    @NotBlank(message = "Password cannot be empty!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Password must be minimum 6 characters " +
            "at least 1 Alphabet and 1 Number!")
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public EditUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EditUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EditUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public EditUserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EditUserDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Long getId() {
        return id;
    }

    public EditUserDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
