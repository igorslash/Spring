package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ComboPoint {
    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsUnilibrary(){}

    @Pointcut("execution(* aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}

    @Pointcut("allMethodsUnilibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnUniLibrary(){}

    @Before("allMethodsExceptReturnUniLibrary()")
    public void allGetReturnMethodsMagazine() {
        System.out.println("LOg4");
    }
}
