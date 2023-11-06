package bg.softuni.theinternetgamedatabase.web.rest;

import bg.softuni.theinternetgamedatabase.model.dto.LoginUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<LoginUserDTO> login(LoginUserDTO loginUserDTO) {

        return ResponseEntity.ok(loginUserDTO);

    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserDTO> register(RegisterUserDTO registerUserDTO) {


        System.out.println();
        return ResponseEntity.ok(registerUserDTO);
    }

}
