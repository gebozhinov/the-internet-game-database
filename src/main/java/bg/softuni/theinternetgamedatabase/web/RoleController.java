package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.user.UsernameDTO;
import bg.softuni.theinternetgamedatabase.service.RoleService;
import bg.softuni.theinternetgamedatabase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    private final UserService userService;
    public RoleController(RoleService roleService,
                          UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/edit")
    public String edit(Model model) {

        Map<String, String> usernameUserRoleViews = this.roleService.findAllUsernamesByUserRole();
        model.addAttribute("usernameUserRoleViews", usernameUserRoleViews);


        return "role-edit";
    }

    @PostMapping("/edit/admin")
    public String edit(UsernameDTO usernameDTO) {

        if (usernameDTO.getUsername() == null) {
            return "redirect:/roles/edit";
        }
        this.userService.addAdminRole(usernameDTO);

        return "redirect:/roles/edit";
    }
}
