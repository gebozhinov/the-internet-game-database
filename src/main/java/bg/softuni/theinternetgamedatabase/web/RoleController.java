package bg.softuni.theinternetgamedatabase.web;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
@Repository("/roles")
public class RoleController {

    public String edit() {


        return "role-edit";
    }
}
