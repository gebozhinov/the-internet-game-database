package bg.softuni.theinternetgamedatabase.model.dto;

import bg.softuni.theinternetgamedatabase.model.validation.EqualPassword;
import bg.softuni.theinternetgamedatabase.model.validation.UniqueData;
import jakarta.validation.constraints.*;

@EqualPassword
public class RegisterUserDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    @UniqueData(fieldName = "username")
    private String username;
    @NotBlank
    @Email
    @UniqueData(fieldName = "email")
    private String email;
    @PositiveOrZero
    @NotNull
    private Integer age;
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public RegisterUserDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
