package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.EditUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.RegisterUserDTO;
import bg.softuni.theinternetgamedatabase.model.dto.UserDTO;
import bg.softuni.theinternetgamedatabase.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerUserDTO")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }
    @ModelAttribute("editUserDTO")
    public EditUserDTO editUserDTO() {
        return new EditUserDTO();
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
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

        this.userService.register(registerUserDTO);

        return "redirect:/";
    }

    @GetMapping("/users/edit")
    public String edit(Model model) {

        List<UserDTO> allUsernames = this.userService.findAllUsernames();
        model.addAttribute("allUsernames", allUsernames);

        return "user-edit";
    }

    @GetMapping("/users/edit/{id}")
    public String userDetail(@PathVariable Long id, Model model) {

        EditUserDTO editUserDTO = this.userService.findById(id);
        model.addAttribute("editUserDTO", editUserDTO);

        return "user-details";
    }

    @PostMapping("/users/edit/{id}")
    public String userDetail(@PathVariable Long id, @Valid EditUserDTO editUserDTO,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

//        EditUserDTO editUserDTO = this.userService.findById(id);
//        model.addAttribute("editUserDTO", editUserDTO);

        if (!editUserDTO.getPassword().equals(editUserDTO.getConfirmPassword())) {
            redirectAttributes.addAttribute("password doesnt match");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("editUserDTO", editUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.editUserDTO",
                    bindingResult);

            return "redirect:/users/edit/" + id;
        }

        return "redirect:/";
    }
}
