package bg.softuni.theinternetgamedatabase.web.rest;

import bg.softuni.theinternetgamedatabase.model.dto.LoginUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<LoginUserDTO> login(LoginUserDTO loginUserDTO) {

        return ResponseEntity.ok(loginUserDTO);

    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<RegisterUserDTO> register(@Valid RegisterUserDTO registerUserDTO,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            // todo
        }

        return ResponseEntity.ok(registerUserDTO);
    }

}
