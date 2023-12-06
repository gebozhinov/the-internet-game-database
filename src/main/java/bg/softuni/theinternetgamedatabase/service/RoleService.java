package bg.softuni.theinternetgamedatabase.service;


import bg.softuni.theinternetgamedatabase.model.view.UsernameUserRoleView;
import bg.softuni.theinternetgamedatabase.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

   public Map<String, String> findAllUsernamesByUserRole() {

       Map<String, String> usernameUserRole = new HashMap<>();
       List<UsernameUserRoleView> views = this.roleRepository.findAllUsernamesUserRoles().orElse(new ArrayList<>());

       for (UsernameUserRoleView view : views) {

           String username = view.getUsername();
           String userRole = view.getUser_Role();
           if (!usernameUserRole.containsKey(username)) {
               usernameUserRole.put(username, userRole);
               continue;
           }
           if (userRole.equals("USER")) {
               continue;
           }
           usernameUserRole.put(username, userRole);

           if (userRole.equals("MODERATOR")) {
               continue;
           }
           usernameUserRole.put(username, userRole);

       }


       return usernameUserRole;
    }

}
