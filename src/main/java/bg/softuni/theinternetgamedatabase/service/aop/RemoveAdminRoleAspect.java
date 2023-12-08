package bg.softuni.theinternetgamedatabase.service.aop;

import bg.softuni.theinternetgamedatabase.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RemoveAdminRoleAspect {

    private final UserService userService;

    public RemoveAdminRoleAspect(UserService userService) {
        this.userService = userService;
    }

    @Before("PointCuts.removeAdminRole()")
    public void removeAdminRole() {
        this.userService.removeAdminRole();
    }
}
