package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.LoginUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;

@Controller
public class UserController {


    @ModelAttribute("registerUserDTO")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }

    @GetMapping("/login")
    public String home() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping( "/login")
    public String login(LoginUserDTO loginUserDTO) {

        return "redirect:/login";

    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(@Valid RegisterUserDTO registerUserDTO,
                                                    BindingResult bindingResult,
                                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("registerUserDTO", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO",
                    bindingResult);


            return "redirect:/register";

        }

        return "redirect:/home";
    }


}
