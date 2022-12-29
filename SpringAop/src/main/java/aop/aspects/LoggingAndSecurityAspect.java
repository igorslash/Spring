package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
    @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeGetAdvised() {
        System.out.println("login: get the  book and magazine");
    }

    @Before("allGetMethods()")
    public void beforeSecurityGetAdvised() {
        System.out.println("examination get the rights book and magazine");
    }
}
