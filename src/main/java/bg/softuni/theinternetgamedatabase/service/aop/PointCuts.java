package bg.softuni.theinternetgamedatabase.service.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* bg.softuni.theinternetgamedatabase.service.UserService.addAdminRole(..))")
    public void removeAdminRole(){}
}
