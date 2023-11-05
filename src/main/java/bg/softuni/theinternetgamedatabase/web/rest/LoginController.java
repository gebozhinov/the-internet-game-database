package bg.softuni.theinternetgamedatabase.web.rest;

import bg.softuni.theinternetgamedatabase.model.dto.LoginUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<LoginUserDTO> login(LoginUserDTO loginUserDTO) {



        return ResponseEntity.ok(loginUserDTO);

    }

}
