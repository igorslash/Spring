package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ComboPointcats {
    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void returnAllMethodsFromUniLibrary() {}

    @Pointcut("allGetMethodsFromUniLibrary() || returnAllMethodsFromUniLibrary()")
    private void allMethodsFromUniLibrary() {}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeLoggingAdvice() {
        System.out.println("writing log1");
    }
    @Before("returnAllMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("return log2");
    }
    @Before("allMethodsFromUniLibrary()")
    public void allGetReturnMethodsLibrary() {
        System.out.println("LOg3");
    }
}
